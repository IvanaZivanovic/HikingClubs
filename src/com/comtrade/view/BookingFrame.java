package com.comtrade.view;


import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.comtrade.controllerFC.KontrolerFK;
import com.comtrade.domen.Akcija;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.Planinar;
import com.comtrade.domen.Rezervacija;
import com.comtrade.domen.TransferKlasa;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingFrame extends JFrame {
	// to do: translate variables from serbian to english 

	private JPanel contentPane;
	private JTable tableAkcija;
	private JTable tablePlaninar;
	private JTextField tfDestination;
	private JTextField tfHiker;
	private List<Akcija> listaAkcija;
	private List<Planinar> listaPlaninara;
	private List<Rezervacija> listaRezervacija;
	private int idAkcija;
	private int idPlaninar;
	private DefaultTableModel dtmA = new DefaultTableModel();
	private DefaultTableModel dtmP = new DefaultTableModel();
	private JDateChooser dateChooserSTART;
	private JDateChooser dateChooserEND; 
	private JRadioButton rdbtnSearchByDestination;
	private JRadioButton rdbtnSearchByDate;
	private ButtonGroup searchActions = new ButtonGroup();
	private ChronoLocalDate istekClanarine;
	private ChronoLocalDate datumAkcije;
	
	
	

	/**
	 * Create the frame.
	 */
	public BookingFrame() {
		TransferKlasa transferKlasaAkcija = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.AKCIJA, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasaAkcija);
		listaAkcija = (List<Akcija>) transferKlasaAkcija.getResponse();
		
		TransferKlasa transferKlasaPlaninar = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.PLANINAR, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasaPlaninar);
		listaPlaninara = (List<Planinar>) transferKlasaPlaninar.getResponse();
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(tableAkcija);
		scrollPane.setBounds(28, 144, 965, 183);
		contentPane.add(scrollPane);
		
		tableAkcija = new JTable(dtmA);
		tableAkcija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = tableAkcija.getSelectedRow();
				idAkcija = (int) tableAkcija.getModel().getValueAt(red, 0);
				String datum = tableAkcija.getModel().getValueAt(red, 2).toString();
				String [] niz = datum.split("-");
				int godina = Integer.parseInt(niz[0]);
				int mesec = Integer.parseInt(niz[1]);
				int dan = Integer.parseInt(niz[2]);
				datumAkcije = LocalDate.of(godina, mesec, dan);
				
				
			}
		});
		scrollPane.setViewportView(tableAkcija);
		
		Object [] koloneA = {"ID", "Destination", "Date", "Type", "Price", "Link", "Club", "Guide"};
		dtmA.addColumn(koloneA[0]);
		dtmA.addColumn(koloneA[1]);
		dtmA.addColumn(koloneA[2]);
		dtmA.addColumn(koloneA[3]);
		dtmA.addColumn(koloneA[4]);
		dtmA.addColumn(koloneA[5]);
		dtmA.addColumn(koloneA[6]);
		dtmA.addColumn(koloneA[7]);
		postaviPodatkeUAkcije();
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pretraziAkcije();
			}
			
		});
		btnSearch.setBounds(516, 94, 152, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane(tablePlaninar);
		scrollPane_1.setBounds(28, 444, 965, 141);
		contentPane.add(scrollPane_1);
		
		tablePlaninar = new JTable(dtmP);
		tablePlaninar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = tablePlaninar.getSelectedRow();
				idPlaninar = (int) tablePlaninar.getModel().getValueAt(red, 0);
				String datum = tablePlaninar.getModel().getValueAt(red, 5).toString();
				String [] niz = datum.split("-");
				int godina = Integer.parseInt(niz[0]);
				int mesec = Integer.parseInt(niz[1]);
				int dan = Integer.parseInt(niz[2]);
				istekClanarine = LocalDate.of(godina, mesec, dan);
			}
		});
		scrollPane_1.setViewportView(tablePlaninar);
		
		Object [] koloneP = {"Hiker's ID", "First name", "Last name", "Year of Birth", "Card", "Valid until", "Phone number", "email", "Club"};
		dtmP.addColumn(koloneP[0]);
		dtmP.addColumn(koloneP[1]);
		dtmP.addColumn(koloneP[2]);
		dtmP.addColumn(koloneP[3]);
		dtmP.addColumn(koloneP[4]);
		dtmP.addColumn(koloneP[5]);
		dtmP.addColumn(koloneP[6]);
		dtmP.addColumn(koloneP[7]);
		dtmP.addColumn(koloneP[8]);
		postaviPodatkeUPlaninara();
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(53, 51, 147, 14);
		contentPane.add(lblDestination);
		
		tfDestination = new JTextField();
		tfDestination.setBounds(210, 48, 261, 20);
		contentPane.add(tfDestination);
		tfDestination.setColumns(10);
		
		JLabel lblHiker = new JLabel("Hiker");
		lblHiker.setBounds(44, 384, 95, 14);
		contentPane.add(lblHiker);
		
		tfHiker = new JTextField();
		tfHiker.setBounds(195, 378, 298, 20);
		contentPane.add(tfHiker);
		tfHiker.setColumns(10);
		
		JButton btnSearchAllHikers = new JButton("Search");
		btnSearchAllHikers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pretraziPlaninare();
			}

			
		});
		btnSearchAllHikers.setBounds(629, 378, 152, 23);
		contentPane.add(btnSearchAllHikers);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Akcija akcija = new Akcija();
				akcija.setIdAkcija(idAkcija);
				
				Planinar planinar = new Planinar();
				planinar.setIdPlaninar(idPlaninar);
				
				Rezervacija rezervacija = new Rezervacija(akcija, planinar);
				
				if(akcija.getIdAkcija()==0 || planinar.getIdPlaninar() ==0) {
					JOptionPane.showMessageDialog(null, "Please choose a hiker and an activity");
				} else if (!proveriClanarinu()){
					JOptionPane.showMessageDialog(null, "Membership expires before this activity, please renew it, then try again");
				} else if (daLiPostojiRez()) {
					JOptionPane.showMessageDialog(null, "This hiker has already signed up for this action");
				} else {
				
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(rezervacija, KontrolerFKKonstanta.REZERVACIJA, KontrolerPLKonstanta.POST);
				KontrolerFK.getInstanca().execute(transferKlasa);
				JOptionPane.showMessageDialog(null, "You have successfully signed up for the activity!");
								
				}
			}

			
			
		});
		btnReserve.setBounds(778, 607, 152, 23);
		contentPane.add(btnReserve);
		
		dateChooserSTART = new JDateChooser();
		dateChooserSTART.setBounds(591, 45, 146, 20);
		contentPane.add(dateChooserSTART);
		
		dateChooserEND= new JDateChooser();
		dateChooserEND.setBounds(787, 45, 154, 20);
		contentPane.add(dateChooserEND);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(648, 19, 89, 14);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(806, 16, 135, 14);
		contentPane.add(lblEnd);
		
		rdbtnSearchByDestination = new JRadioButton("Search by Destination");
		rdbtnSearchByDestination.setBounds(195, 94, 178, 23);
		contentPane.add(rdbtnSearchByDestination);
		searchActions.add(rdbtnSearchByDestination);
		
		rdbtnSearchByDate = new JRadioButton("Search by Date");
		rdbtnSearchByDate.setBounds(382, 94, 147, 23);
		contentPane.add(rdbtnSearchByDate);
		searchActions.add(rdbtnSearchByDate);
		
		JButton btnShowAllTours = new JButton("Show All Tours");
		btnShowAllTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatkeUAkcije();
				clearSvaPolja();
				idAkcija = 0;
			}

			
		});
		btnShowAllTours.setBounds(789, 94, 152, 23);
		contentPane.add(btnShowAllTours);
		
		JButton btnShowAllHikers = new JButton("Show All Hikers");
		btnShowAllHikers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatkeUPlaninara();
				clearSvaPolja();
				idPlaninar = 0;
			}
		});
		btnShowAllHikers.setBounds(807, 378, 123, 23);
		contentPane.add(btnShowAllHikers);
		
	}



	private void postaviPodatkeUPlaninara() {
		// TODO Auto-generated method stub
		dtmP.setRowCount(0);
		for (Planinar p1 : listaPlaninara) {
			Object [] red = {p1.getIdPlaninar(), p1.getIme(), p1.getPrezime(), p1.getGodiste(), p1.getBrojClanskeKarte(), p1.getIstekClanarine(), p1.getBrojTelefona(), p1.getEmail(), p1.getKlub().getNaziv()};
			dtmP.addRow(red);
		}
		
	}



	private void postaviPodatkeUAkcije() {
		// TODO Auto-generated method stub
		dtmA.setRowCount(0);
		for (Akcija akcija : listaAkcija) {
			Object [] red = {akcija.getIdAkcija(), akcija.getDestinacija(), akcija.getDatumAkcije(), akcija.getTipAKcije(), akcija.getCena(), akcija.getLinkAkcije(), akcija.getKlub().getNaziv(), akcija.getVodic().getIme() + " " + akcija.getVodic().getPrezime() + " " + akcija.getVodic().getBrojLicence()};
			dtmA.addRow(red);
			
		}
		
	}
	private void pretraziPlaninare() {
		// TODO Auto-generated method stub
		dtmP.setRowCount(0);
		for (Planinar p1 : listaPlaninara) {
			if(p1.getIme().contains(tfHiker.getText().toString())) {
				setRed(p1);
			}
		}
	}

	private void setRed(Planinar p1) {
		// TODO Auto-generated method stub
		Object [] redObjects = {p1.getIdPlaninar(), p1.getIme(), p1.getPrezime(), p1.getGodiste(), p1.getBrojClanskeKarte(), p1.getIstekClanarine(), p1.getBrojTelefona(), p1.getEmail(), p1.getKlub().getNaziv()};
		dtmP.addRow(redObjects);
	}
	
	private void clearSvaPolja() {
		// TODO Auto-generated method stub
		tfDestination.setText("");
		tfHiker.setText("");
		dateChooserSTART.setDate(new Date());
		dateChooserEND.setDate(new Date());
	}
	
	private void pretraziAkcije() {
		// TODO Auto-generated method stub
		dtmA.setRowCount(0);
		if (rdbtnSearchByDestination.isSelected()) {
			for (Akcija a : listaAkcija) {
				if(a.getDestinacija().contains(tfDestination.getText())) {
					setRed(a);
				}
				
			}
		} else if (rdbtnSearchByDate.isSelected()) {
			
			int dan = dateChooserSTART.getJCalendar().getDayChooser().getDay();
			int mesec = dateChooserSTART.getJCalendar().getMonthChooser().getMonth()+1;
			int godina = dateChooserSTART.getJCalendar().getYearChooser().getYear();
			ChronoLocalDate pocetak = LocalDate.of(godina, mesec, dan);
			
			int dan1 = dateChooserEND.getJCalendar().getDayChooser().getDay();
			int mesec1 = dateChooserEND.getJCalendar().getMonthChooser().getMonth()+1;
			int godina1 = dateChooserEND.getJCalendar().getYearChooser().getYear();
			ChronoLocalDate  kraj = LocalDate.of(godina1, mesec1, dan1);
			
			for (Akcija a : listaAkcija) {
				if(a.getDatumAkcije().isBefore(kraj) && a.getDatumAkcije().isAfter(pocetak)) {
					setRed(a);
				}
								
			}
		}
	}

	private void setRed(Akcija akcija) {
		// TODO Auto-generated method stub
		Object [] red = {akcija.getIdAkcija(), akcija.getDestinacija(), akcija.getDatumAkcije(), akcija.getTipAKcije(), akcija.getCena(), akcija.getLinkAkcije(), akcija.getKlub().getNaziv(), akcija.getVodic().getIme() + " " + akcija.getVodic().getPrezime() + " " + akcija.getVodic().getBrojLicence()};
		dtmA.addRow(red);
	}
	private boolean proveriClanarinu() {
		boolean moze = true; 
		// TODO Auto-generated method stub
		if (datumAkcije.isAfter(istekClanarine)) {
			moze = false;
		} else moze = true;
		return moze;
	}
	
	private boolean daLiPostojiRez() {
		boolean postoji = true;
		TransferKlasa transferKlasaRez = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.REZERVACIJA, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasaRez);
		listaRezervacija = (List<Rezervacija>) transferKlasaRez.getResponse();
		// TODO Auto-generated method stub
		for (Rezervacija r : listaRezervacija) {
			if (r.getAkcija().getIdAkcija() == idAkcija && r.getPlaninar().getIdPlaninar() == idPlaninar) {
				
				postoji = true;
			} else postoji = false;
			
		}
		return postoji;
	}

	
}

