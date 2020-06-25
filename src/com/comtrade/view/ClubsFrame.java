package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controllerFC.KontrolerFK;
import com.comtrade.domen.Adresa;
import com.comtrade.domen.Klub;
import com.comtrade.domen.Kontakt;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ClubsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfTin;
	private JLabel lblCity;
	private JTextField tfCity;
	private JTextField tfZipCode;
	private JTextField tfStreet;
	private JTextField tfPhoneNumber;
	private JTextField tfEmail;
	private JTextField tfWebAddress;
	private JTable table;
	private JTextField tfStreetNumber;
	private DefaultTableModel dtm = new DefaultTableModel();
	private Integer idKlub;
	private List<Klub> klubovi;

	

	/**
	 * Create the frame.
	 */
	public ClubsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 51, 66, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(77, 48, 185, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTin = new JLabel("TIN");
		lblTin.setBounds(288, 51, 40, 14);
		contentPane.add(lblTin);
		
		tfTin = new JTextField();
		tfTin.setBounds(328, 48, 147, 20);
		contentPane.add(tfTin);
		tfTin.setColumns(10);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(496, 51, 46, 14);
		contentPane.add(lblCity);
		
		tfCity = new JTextField();
		tfCity.setBounds(570, 48, 167, 20);
		contentPane.add(tfCity);
		tfCity.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(786, 51, 89, 14);
		contentPane.add(lblZipCode);
		
		tfZipCode = new JTextField();
		tfZipCode.setBounds(885, 48, 103, 20);
		contentPane.add(tfZipCode);
		tfZipCode.setColumns(10);
		
		JLabel lblStreetName = new JLabel("Street name");
		lblStreetName.setBounds(25, 93, 82, 14);
		contentPane.add(lblStreetName);
		
		tfStreet = new JTextField();
		tfStreet.setBounds(131, 90, 223, 20);
		contentPane.add(tfStreet);
		tfStreet.setColumns(10);
		
		JLabel lblStreetNumber = new JLabel("Street number");
		lblStreetNumber.setBounds(382, 93, 109, 14);
		contentPane.add(lblStreetNumber);
		
		tfStreetNumber = new JTextField();
		tfStreetNumber.setBounds(501, 90, 121, 20);
		contentPane.add(tfStreetNumber);
		tfStreetNumber.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(689, 93, 103, 14);
		contentPane.add(lblPhoneNumber);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setBounds(821, 90, 167, 20);
		contentPane.add(tfPhoneNumber);
		tfPhoneNumber.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(45, 141, 62, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(90, 138, 264, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblWebAddress = new JLabel("Web address");
		lblWebAddress.setBounds(476, 141, 82, 14);
		contentPane.add(lblWebAddress);
		
		tfWebAddress = new JTextField();
		tfWebAddress.setBounds(568, 138, 326, 20);
		contentPane.add(tfWebAddress);
		tfWebAddress.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = tfName.getText();
				String pib = tfTin.getText();
				Klub klub = new Klub(naziv, pib);
				
				String mesto = tfCity.getText();
				int postanskiBroj = Integer.parseInt(tfZipCode.getText());
				String ulica = tfStreet.getText();
				String broj = tfStreetNumber.getText();
				Adresa adresa = new Adresa(mesto, postanskiBroj, ulica, broj);
				
				String brojTelefona = tfPhoneNumber.getText();
				String email = tfEmail.getText();
				String webSajt = tfWebAddress.getText();
				Kontakt kontakt = new Kontakt(brojTelefona, email, webSajt);
				klub.setAdresa(adresa);
				klub.setKontakt(kontakt);
								
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setRequest(klub);
				transferKlasa.setKontrolerFK(KontrolerFKKonstanta.KLUB);
				transferKlasa.setKontrolerPL(KontrolerPLKonstanta.POST);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatke();
				clearSvaPolja();
								
			}

			
		});
		btnSave.setBounds(45, 196, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnIEdit = new JButton("Edit");
		btnIEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = tfName.getText();
				String pib = tfTin.getText();
				Klub klub = new Klub(naziv, pib);
				klub.setIdKlub(idKlub);
				
				String mesto = tfCity.getText();
				int postanskiBroj = Integer.parseInt(tfZipCode.getText());
				String ulica = tfStreet.getText();
				String broj = tfStreetNumber.getText();
				Adresa adresa = new Adresa(mesto, postanskiBroj, ulica, broj);
				
				String brojTelefona = tfPhoneNumber.getText();
				String email = tfEmail.getText();
				String webSajt = tfWebAddress.getText();
				Kontakt kontakt = new Kontakt(brojTelefona, email, webSajt);
				klub.setAdresa(adresa);
				klub.setKontakt(kontakt);
				TransferKlasa transferKlasa = TransferKlasa.kreirajRequest(klub, KontrolerFKKonstanta.KLUB, KontrolerPLKonstanta.PUT);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatke();
				clearSvaPolja();
			}
		});
		btnIEdit.setBounds(198, 196, 89, 23);
		contentPane.add(btnIEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setKontrolerFK(KontrolerFKKonstanta.KLUB);
				transferKlasa.setKontrolerPL(KontrolerPLKonstanta.DELETE);
				Klub klub = new Klub();
				klub.setIdKlub(idKlub);
				transferKlasa.setRequest(klub);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatke();
				clearSvaPolja();
			}
		});
		btnDelete.setBounds(328, 196, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSearchByName = new JButton("Search by name");
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = tfName.getText();
				pretraziKlubove(naziv);
			}

			
		});
		btnSearchByName.setBounds(636, 196, 185, 23);
		contentPane.add(btnSearchByName);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 251, 1067, 221);
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
				idKlub = Integer.parseInt(table.getModel().getValueAt(red,0).toString());
				tfName.setText(table.getModel().getValueAt(red, 1).toString());
				tfTin.setText(table.getModel().getValueAt(red, 2).toString());
				tfCity.setText(table.getModel().getValueAt(red, 3).toString());
				tfZipCode.setText(table.getModel().getValueAt(red, 4).toString());
				tfStreet.setText(table.getModel().getValueAt(red, 5).toString());
				tfStreetNumber.setText(table.getModel().getValueAt(red, 6).toString());
				tfPhoneNumber.setText(table.getModel().getValueAt(red, 7).toString());
				tfEmail.setText(table.getModel().getValueAt(red, 8).toString());
				tfWebAddress.setText(table.getModel().getValueAt(red, 9).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnLoadAll = new JButton("Load All");
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatke();
				clearSvaPolja();
			}
		});
		btnLoadAll.setBounds(920, 196, 89, 23);
		contentPane.add(btnLoadAll);
		Object[]kolone = {"Club's ID", "Name", "TIN", "City", "Zip code", "Street name", "Street number", "Phone number", "e-mail", "web address"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		dtm.addColumn(kolone[8]);
		dtm.addColumn(kolone[9]);
		postaviPodatke();
	}
	
	private void postaviPodatke() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKontrolerFK(KontrolerFKKonstanta.KLUB);
		transferKlasa.setKontrolerPL(KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		klubovi = (List<Klub>) transferKlasa.getResponse();
		for(Klub klub : klubovi) {
			Object[]red = {klub.getIdKlub(), klub.getNaziv(), klub.getPib(), klub.getAdresa().getMesto(), klub.getAdresa().getPostanski_broj(), klub.getAdresa().getUlica(), klub.getAdresa().getBroj(),klub.getKontakt().getBrojTelefona(), klub.getKontakt().getEmail(), klub.getKontakt().getWebSajt()};
			dtm.addRow(red);
		}
	}
	
	private void clearSvaPolja() {
		tfName.setText("");
		tfTin.setText("");
		tfCity.setText("");
		tfStreet.setText("");
		tfStreetNumber.setText("");
		tfPhoneNumber.setText("");
		tfEmail.setText("");
		tfWebAddress.setText("");
		tfZipCode.setText("");
	}
	
	private void pretraziKlubove(String naziv) {
		dtm.setRowCount(0);
		for (Klub klub : klubovi) {
			if(klub.getNaziv().contains(naziv)) {
				setRed(klub);
			}
		}
	}

	private void setRed(Klub klub) {
		Object [] red = {klub.getIdKlub(), klub.getNaziv(), klub.getPib(), klub.getAdresa().getMesto(), klub.getAdresa().getPostanski_broj(), klub.getAdresa().getUlica(), klub.getAdresa().getBroj(), klub.getKontakt().getBrojTelefona(), klub.getKontakt().getEmail(), klub.getKontakt().getWebSajt()};
		dtm.addRow(red);
	}
}
