package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import com.comtrade.controlerFK.KontrolerFK;
import com.comtrade.domen.Akcija;
import com.comtrade.domen.Klub;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.Vodic;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AkcijeForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfDestination;
	private JTextField tfActivityType;
	private JTextField tfPrice;
	private JTextField tfLink;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JDateChooser dateChooser_START;
	private JDateChooser dateChooser_END;
	private JRadioButton rdbtnSearchByDate;
	private JRadioButton rdbtnSearchByDestination;
	private ButtonGroup bgSearch = new ButtonGroup();
	private JComboBox comboBoxGuide;
	private JComboBox comboBoxClub;
	private List<Klub> listaKlubova;
	private List<Vodic> listaVodica;
	private int idAkcija;
	private int idKlub;
	private int idVodic;
	private List<Vodic>listaSvihVodica;
	private List<Akcija> listaAkcija;
	

	

	/**
	 * Create the frame.
	 */
	public AkcijeForma() {
		TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.KLUB, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		listaKlubova = (List<Klub>) transferKlasa.getResponse();
		
		TransferKlasa transferKlasa2 = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.VODIC, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa2);
		listaSvihVodica = (List<Vodic>) transferKlasa2.getResponse();
		
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(49, 61, 91, 14);
		contentPane.add(lblDestination);
		
		tfDestination = new JTextField();
		tfDestination.setBounds(173, 58, 213, 20);
		contentPane.add(tfDestination);
		tfDestination.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(459, 58, 79, 14);
		contentPane.add(lblDate);
		
		JLabel lblActivityType = new JLabel("Activity type");
		lblActivityType.setBounds(49, 133, 91, 14);
		contentPane.add(lblActivityType);
		
		tfActivityType = new JTextField();
		tfActivityType.setBounds(173, 130, 335, 20);
		contentPane.add(tfActivityType);
		tfActivityType.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(659, 133, 46, 14);
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(750, 130, 133, 20);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(49, 196, 46, 14);
		contentPane.add(lblClub);
		
		comboBoxClub = new JComboBox();
		comboBoxClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxClub.getSelectedItem().equals("Select Club") || comboBoxClub.getSelectedItem().equals("--------------------")) {
					comboBoxGuide.removeAllItems();
					idKlub = 0;
				} 
				else { String nazivKluba = comboBoxClub.getSelectedItem().toString();
				for (Klub k1 : listaKlubova) {
					if 	(nazivKluba.equals(k1.getNaziv())) {
						idKlub = k1.getIdKlub();
						//klub.setNaziv(k1.getNaziv());
						
						break;	
					}
				} 
				Klub klub = new Klub();
				klub.setIdKlub(idKlub);
				Vodic vodic = new Vodic();
				vodic.setKlub(klub);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(vodic, KontrolerFKKonstanta.VODIC, KontrolerPLKonstanta.GET_JEDAN);
				KontrolerFK.getInstanca().execute(transferKlasa);
				listaVodica = (List<Vodic>) transferKlasa.getResponse();
				//comboBoxGuide.removeAllItems();
				popuniComboBoxVodic();
			}
			}
			});
		comboBoxClub.setBounds(143, 193, 309, 20);
		contentPane.add(comboBoxClub);
		
		JLabel lblGuide = new JLabel("Guide");
		
		lblGuide.setBounds(535, 196, 46, 14);
		contentPane.add(lblGuide);
		
		comboBoxGuide = new JComboBox();
		
			comboBoxGuide.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//if (comboBoxGuide.getSelectedItem().equals("Select Guide") || comboBoxGuide.getSelectedItem().equals("--------------------")) {
						//JOptionPane.showMessageDialog(null, "Please choose a guide");
					//} else {
						String vodic = comboBoxGuide.getSelectedItem().toString();
						for (Vodic v : listaVodica) {
							if (vodic.contains(v.getBrojLicence())) {
								idVodic = v.getIdVodic();
								break;
							}
							
						}
						
					//}
										
				}
			});
				
		comboBoxGuide.setBounds(615, 196, 316, 20);
		contentPane.add(comboBoxGuide);
		
		JLabel lblLink = new JLabel("Link");
		lblLink.setBounds(49, 250, 62, 14);
		contentPane.add(lblLink);
		
		tfLink = new JTextField();
		tfLink.setBounds(173, 247, 458, 20);
		contentPane.add(tfLink);
		tfLink.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(idKlub==0 ) {
					JOptionPane.showMessageDialog(null, "Izaberite klub");
				} else if (idVodic==0) { JOptionPane.showMessageDialog(null, "Izaberite vodica u save");
					
				} else 	{*/
				Akcija akcija = pokupiPodatkeSaPolja();
				
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(akcija, KontrolerFKKonstanta.AKCIJA, KontrolerPLKonstanta.POST);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearSvaPolja();
				}
		//}

			

			
		});
		btnSave.setBounds(143, 297, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Akcija akcija = pokupiPodatkeSaPolja();
				akcija.setIdAkcija(idAkcija);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(akcija, KontrolerFKKonstanta.AKCIJA, KontrolerPLKonstanta.PUT);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}
		});
		btnEdit.setBounds(249, 297, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Akcija akcija = new Akcija();
				akcija.setIdAkcija(idAkcija);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(akcija, KontrolerFKKonstanta.AKCIJA, KontrolerPLKonstanta.DELETE);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}
		});
		btnDelete.setBounds(363, 297, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pretraziAkcije();
			}
		});
		btnSearch.setBounds(594, 365, 89, 23);
		contentPane.add(btnSearch);
		
		rdbtnSearchByDate = new JRadioButton("Search by Date");
		rdbtnSearchByDate.setBounds(283, 365, 125, 23);
		contentPane.add(rdbtnSearchByDate);
		bgSearch.add(rdbtnSearchByDate);
		
		rdbtnSearchByDestination = new JRadioButton("Search by Destination");
		rdbtnSearchByDestination.setBounds(428, 365, 160, 23);
		contentPane.add(rdbtnSearchByDestination);
		bgSearch.add(rdbtnSearchByDestination);
		
		dateChooser_START = new JDateChooser();
		dateChooser_START.setBounds(548, 58, 135, 20);
		contentPane.add(dateChooser_START);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(37, 420, 948, 162);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				idAkcija = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				
				tfDestination.setText(table.getModel().getValueAt(red, 1).toString());
				String datumAkcije = table.getModel().getValueAt(red, 2).toString();
				String [] niz = datumAkcije.split("-");
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Date datum = Date.from(getDate(niz).atStartOfDay(defaultZoneId).toInstant());
				dateChooser_START.setDate(datum);
				tfActivityType.setText(table.getModel().getValueAt(red, 3).toString());
				tfPrice.setText(table.getModel().getValueAt(red, 4).toString());
				tfLink.setText(table.getModel().getValueAt(red, 5).toString());
				
				/*Klub klub1 = new Klub();
				klub1.setNaziv(table.getModel().getValueAt(red, 6).toString());
				for (Klub klub : listaKlubova) {
					if (klub.getNaziv().equals(klub1.getNaziv())) {
						comboBoxClub.getModel().setSelectedItem(klub.getNaziv());
					}
				}
				
				String vodic = table.getModel().getValueAt(red, 7).toString();
				for (Vodic v : listaVodica) {
					if(vodic.contains(v.getBrojLicence())) {
						comboBoxGuide.getModel().setSelectedItem(vodic);
					}
					
				}*/
				
			}
		});
		scrollPane.setViewportView(table);
		
		dateChooser_END = new JDateChooser();
		dateChooser_END.setBounds(748, 61, 135, 20);
		contentPane.add(dateChooser_END);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(585, 33, 46, 14);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(785, 33, 46, 14);
		contentPane.add(lblEnd);
		
		JButton btnLoadAll = new JButton("Load All");
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}
		});
		btnLoadAll.setBounds(799, 365, 89, 23);
		contentPane.add(btnLoadAll);
		
		Object [] kolone = {"ID", "Destination", "Date", "Type", "Price", "Link", "Club", "Guide"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		popuniComboBoxKlub();
		//comboBoxGuide.removeAllItems();
		//popuniComboBoxVodic();
		postaviPodatkeUTabelu();		
	}

	private void popuniComboBoxVodic() {
		// TODO Auto-generated method stub
		comboBoxGuide.removeAllItems();
		//comboBoxGuide.addItem("Select Guide");
		//comboBoxGuide.addItem("--------------------");
		for (Vodic vodic: listaVodica) {
			comboBoxGuide.addItem(vodic.getIme() + " "+ vodic.getPrezime() + " " + vodic.getBrojLicence());
		}
		
	}

	private void popuniComboBoxKlub() {
		// TODO Auto-generated method stub
		comboBoxClub.addItem("Select Club");
		comboBoxClub.addItem(("--------------------"));
		for (Klub klub : listaKlubova) {
			comboBoxClub.addItem(klub.getNaziv());
			
		}
	}
	
	private void postaviPodatkeUTabelu() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.AKCIJA, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		listaAkcija = (List<Akcija>) transferKlasa.getResponse();
		
		//{"ID", "Destination", "Date", "Type", "Price", "Link", "Club", "Guide"};
		for (Akcija akcija : listaAkcija) {
			Object [] red = {akcija.getIdAkcija(), akcija.getDestinacija(), akcija.getDatumAkcije(), akcija.getTipAKcije(), akcija.getCena(), akcija.getLinkAkcije(), akcija.getKlub().getNaziv(), akcija.getVodic().getIme() + " " + akcija.getVodic().getPrezime() + " " + akcija.getVodic().getBrojLicence()};
			dtm.addRow(red);
			
		}
		
	}
	
	private LocalDate getDate(String[] niz) {
		// TODO Auto-generated method stub
		int dan = Integer.parseInt(niz[2]);
		int mesec =  Integer.parseInt(niz[1]);
		int godina =  Integer.parseInt(niz[0]);
		return LocalDate.of(godina, mesec, dan);
	
	}
	
	private void clearSvaPolja() {
		// TODO Auto-generated method stub
		tfDestination.setText("");
		tfActivityType.setText("");
		tfLink.setText("");
		tfPrice.setText("");
		dateChooser_START.setDate(new Date());
		//comboBoxClub.setSelectedItem("Select Club");
		
	}
	
	private Akcija pokupiPodatkeSaPolja() {
		String destinacija = tfDestination.getText();
		
		int dan = dateChooser_START.getJCalendar().getDayChooser().getDay();
		int mesec = dateChooser_START.getJCalendar().getMonthChooser().getMonth()+1;
		int godina = dateChooser_START.getJCalendar().getYearChooser().getYear();
		LocalDate datumAkcije = LocalDate.of(godina, mesec, dan);
		
		String tipAkcije = tfActivityType.getText();
		double cena = Double.parseDouble(tfPrice.getText());
		String link = tfLink.getText();
		
		Klub klub = new Klub();
		klub.setIdKlub(idKlub);
		klub.setNaziv(comboBoxClub.getSelectedItem().toString());
		Vodic vodicAkcije = new Vodic();
		vodicAkcije.setIdVodic(idVodic);
		String vodic = comboBoxGuide.getSelectedItem().toString();
		String niz [] = vodic.split(" ");
		String imeVodica = niz[0];
		String prezimeVodica = niz[1];
		String brojLicence = niz[2];
		vodicAkcije.setIme(imeVodica);
		vodicAkcije.setPrezime(prezimeVodica);
		vodicAkcije.setBrojLicence(brojLicence);
		Akcija akcija = new Akcija(destinacija, datumAkcije, tipAkcije, cena, link);
		akcija.setKlub(klub);
		akcija.setVodic(vodicAkcije);
		return akcija;
				
	}
	
	private void pretraziAkcije() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		if (rdbtnSearchByDestination.isSelected()) {
			for (Akcija a : listaAkcija) {
				if(a.getDestinacija().contains(tfDestination.getText())) {
					setRed(a);
				}
				
			}
		} else if (rdbtnSearchByDate.isSelected()) {
			
			int dan = dateChooser_START.getJCalendar().getDayChooser().getDay();
			int mesec = dateChooser_START.getJCalendar().getMonthChooser().getMonth()+1;
			int godina = dateChooser_START.getJCalendar().getYearChooser().getYear();
			ChronoLocalDate pocetak = LocalDate.of(godina, mesec, dan);
			
			int dan1 = dateChooser_END.getJCalendar().getDayChooser().getDay();
			int mesec1 = dateChooser_END.getJCalendar().getMonthChooser().getMonth()+1;
			int godina1 = dateChooser_END.getJCalendar().getYearChooser().getYear();
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
		dtm.addRow(red);
		
	}
}
