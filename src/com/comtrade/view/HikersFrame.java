package com.comtrade.view;


import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import com.comtrade.controllerFC.KontrolerFK;
import com.comtrade.domen.Klub;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.Planinar;
import com.comtrade.domen.TransferKlasa;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;


public class HikersFrame extends JFrame {
	// to do: translate variables from serbian to english 

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfYearOfBirth;
	private JTextField tfMembershipCard;
	private JTextField tfPhoneNumber;
	private JTextField tfEmail;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Klub> listaKlubova;
	private JComboBox comboBoxClubs;
	private JDateChooser dateChooser; 
	private int idKlub;
	private List<Planinar> listaPlaninara;
	private int idPlaninar;
	private JRadioButton rdbtnSearchByName;
	private JRadioButton rdbtnSearchByClub;
	private ButtonGroup bgPretraga = new ButtonGroup();
	
	
	

	/**
	 * Create the frame.
	 */
	public HikersFrame() {
		TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.KLUB, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		listaKlubova = (List<Klub>) transferKlasa.getResponse();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(30, 55, 146, 14);
		contentPane.add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(207, 49, 135, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(385, 55, 106, 14);
		contentPane.add(lblLastName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(538, 52, 258, 20);
		contentPane.add(tfLastName);
		tfLastName.setColumns(10);
		
		JLabel lblYearOfBirth = new JLabel("Year of birth");
		lblYearOfBirth.setBounds(30, 105, 146, 14);
		contentPane.add(lblYearOfBirth);
		
		tfYearOfBirth = new JTextField();
		tfYearOfBirth.setBounds(207, 99, 135, 20);
		contentPane.add(tfYearOfBirth);
		tfYearOfBirth.setColumns(10);
		
		JLabel lblMembershipCard = new JLabel("Membership card");
		lblMembershipCard.setBounds(385, 105, 156, 14);
		contentPane.add(lblMembershipCard);
		
		tfMembershipCard = new JTextField();
		tfMembershipCard.setBounds(538, 102, 258, 20);
		contentPane.add(tfMembershipCard);
		tfMembershipCard.setColumns(10);
		
		JLabel lblMembership = new JLabel("Membership valid until");
		lblMembership.setBounds(30, 174, 146, 14);
		contentPane.add(lblMembership);
		
		JLabel lblHikingClub = new JLabel("HikingClub");
		lblHikingClub.setBounds(385, 174, 99, 14);
		contentPane.add(lblHikingClub);
		
		comboBoxClubs = new JComboBox();
		comboBoxClubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nazivKluba = comboBoxClubs.getSelectedItem().toString();
				for (Klub k1 : listaKlubova) {
					if(nazivKluba.equals(k1.getNaziv())) {
						idKlub = k1.getIdKlub();
						//klub.setNaziv(k1.getNaziv());
						
						break;	
			}
				}
			}
			});
		comboBoxClubs.setBounds(538, 171, 258, 20);
		contentPane.add(comboBoxClubs);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(30, 238, 146, 14);
		contentPane.add(lblPhoneNumber);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setBounds(207, 232, 135, 20);
		contentPane.add(tfPhoneNumber);
		tfPhoneNumber.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(385, 238, 99, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(538, 235, 258, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planinar planinar = pokupiPodatkeSaPolja();
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(planinar, KontrolerFKKonstanta.PLANINAR, KontrolerPLKonstanta.POST);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}

						
		});
		btnSave.setBounds(30, 301, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planinar planinar = pokupiPodatkeSaPolja();
				planinar.setIdPlaninar(idPlaninar);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(planinar, KontrolerFKKonstanta.PLANINAR, KontrolerPLKonstanta.PUT);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}
		});
		btnEdit.setBounds(155, 301, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planinar planinar = new Planinar();
				planinar.setIdPlaninar(idPlaninar);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(planinar, KontrolerFKKonstanta.PLANINAR, KontrolerPLKonstanta.DELETE);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}
		});
		btnDelete.setBounds(275, 301, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pretraziPlaninare();
			}

			
		});
		btnSearch.setBounds(707, 301, 89, 23);
		contentPane.add(btnSearch);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(207, 171, 135, 20);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setDate(new Date());
		
		rdbtnSearchByName = new JRadioButton("Search by name");
		rdbtnSearchByName.setBounds(412, 301, 140, 23);
		contentPane.add(rdbtnSearchByName);
		bgPretraga.add(rdbtnSearchByName);
		
		rdbtnSearchByClub = new JRadioButton("Search by club");
		rdbtnSearchByClub.setBounds(561, 301, 109, 23);
		contentPane.add(rdbtnSearchByClub);
		bgPretraga.add(rdbtnSearchByClub);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 379, 766, 171);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int red = table.getSelectedRow();
				idPlaninar = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				tfFirstName.setText(table.getModel().getValueAt(red, 1).toString());
				tfLastName.setText(table.getModel().getValueAt(red, 2).toString());
				tfYearOfBirth.setText(table.getModel().getValueAt(red, 3).toString());
				tfMembershipCard.setText(table.getModel().getValueAt(red, 4).toString());
				String validUntil = table.getModel().getValueAt(red, 5).toString();
				String [] niz = validUntil.split("-");
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Date date = Date.from(getDate(niz).atStartOfDay(defaultZoneId).toInstant());
				dateChooser.setDate(date);
				tfPhoneNumber.setText(table.getModel().getValueAt(red, 6).toString());
				tfEmail.setText(table.getModel().getValueAt(red, 7).toString());
				Klub klub1 = new Klub();
				klub1.setNaziv(table.getModel().getValueAt(red, 8).toString());
				for (Klub klub : listaKlubova) {
					if (klub.getNaziv().equals(klub1.getNaziv())) {
						comboBoxClubs.getModel().setSelectedItem(klub.getNaziv());
					}
				}
				
				
				
			}

			

			
		});
		scrollPane.setViewportView(table);
		
		JButton btnLoadAll = new JButton("Load All");
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatkeUTabelu();
				clearSvaPolja();
			}
		});
		btnLoadAll.setBounds(615, 345, 89, 23);
		contentPane.add(btnLoadAll);
		
		Object [] kolone = {"Hiker's ID", "First name", "Last name", "Year of Birth", "Card", "Valid until", "Phone number", "email", "Club"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		dtm.addColumn(kolone[8]);
		postaviPodatkeUTabelu();
		popuniComboBox();
		
	}



	private void popuniComboBox() {
		// TODO Auto-generated method stub
		for (Klub klub : listaKlubova) {
			comboBoxClubs.addItem(klub.getNaziv());
			
		}
		
	}
	
	private void clearSvaPolja() {
		// TODO Auto-generated method stub
		tfFirstName.setText("");
		tfLastName.setText("");
		tfYearOfBirth.setText("");
		tfMembershipCard.setText("");
		tfPhoneNumber.setText("");
		tfEmail.setText("");
		dateChooser.setDate(new Date());
		
	}
	
	private void postaviPodatkeUTabelu() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.PLANINAR, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		listaPlaninara = (List<Planinar>) transferKlasa.getResponse();
		for (Planinar p1 : listaPlaninara) {
			Object [] red = {p1.getIdPlaninar(), p1.getIme(), p1.getPrezime(), p1.getGodiste(), p1.getBrojClanskeKarte(), p1.getIstekClanarine(), p1.getBrojTelefona(), p1.getEmail(), p1.getKlub().getNaziv()};
			dtm.addRow(red);
			
		}
		
	}
	private Planinar pokupiPodatkeSaPolja() {
		// TODO Auto-generated method stub
		String ime = tfFirstName.getText();
		String prezime = tfLastName.getText();
		int godiste = Integer.parseInt(tfYearOfBirth.getText());
		String brojClanskeKarte = tfMembershipCard.getText();
		int dan = dateChooser.getJCalendar().getDayChooser().getDay();
		int mesec = dateChooser.getJCalendar().getMonthChooser().getMonth()+1;
		int godina = dateChooser.getJCalendar().getYearChooser().getYear();
		LocalDate istekClanarine = LocalDate.of(godina, mesec, dan);
		String brojTelefona = tfPhoneNumber.getText();
		String email = tfEmail.getText();
		Planinar planinar = new Planinar(ime, prezime, godiste, brojClanskeKarte, istekClanarine, brojTelefona, email);
		Klub klub = new Klub();
		klub.setIdKlub(idKlub);
		planinar.setKlub(klub);
		
		return planinar;
	}
	
	private LocalDate getDate(String[] niz) {
		// TODO Auto-generated method stub
		int dan = Integer.parseInt(niz[2]);
		int mesec =  Integer.parseInt(niz[1]);
		int godina =  Integer.parseInt(niz[0]);
		return LocalDate.of(godina, mesec, dan);
	
	}
	
	private void pretraziPlaninare() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		if (rdbtnSearchByClub.isSelected()) {
			for (Planinar p1 : listaPlaninara) {
				if (p1.getKlub().getNaziv().equals(comboBoxClubs.getSelectedItem().toString())) {
					setRed(p1);
					continue;
				
			} 
	}
	
		} else if (rdbtnSearchByName.isSelected()) {
			for (Planinar p1 : listaPlaninara) {
				if(p1.getIme().contains(tfFirstName.getText().toString())) {
					setRed(p1);
					continue;
			}	
			}
			
		}
	}



	private void setRed(Planinar p1) {
		// TODO Auto-generated method stub
		Object [] redObjects = {p1.getIdPlaninar(), p1.getIme(), p1.getPrezime(), p1.getGodiste(), p1.getBrojClanskeKarte(), p1.getIstekClanarine(), p1.getBrojTelefona(), p1.getEmail(), p1.getKlub().getNaziv()};
		dtm.addRow(redObjects);
	}
}
