package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerFK.KontrolerFK;
import com.comtrade.domen.Klub;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.Vodic;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;

public class VodicForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfYearOfBirth;
	private JTextField tfPhoneNumber;
	private JTextField tfLicenseNumber;
	private JTextField tfEmail;
	private List <Klub> klubovi;
	private JComboBox comboBoxClubs;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private int idKlub;
	private List<Vodic> listaVodica;
	private int idVodic;
	private Klub klub;
	private ButtonGroup bgPretraga = new ButtonGroup();
	private JRadioButton rdbtnSearchByName;
	private JRadioButton rdbtnSearchByClub;
	

	

	/**
	 * Create the frame.
	 */
	public VodicForma() {
		TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.KLUB, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		klubovi = (List<Klub>) transferKlasa.getResponse();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(39, 27, 85, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(374, 27, 70, 14);
		contentPane.add(lblLastName);
		
		JLabel lblYearOfBirth = new JLabel("Year of Birth");
		lblYearOfBirth.setBounds(39, 80, 85, 14);
		contentPane.add(lblYearOfBirth);
		
		JLabel lblLicenseNumber = new JLabel("License Number");
		lblLicenseNumber.setBounds(374, 80, 100, 14);
		contentPane.add(lblLicenseNumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(39, 139, 85, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(374, 139, 70, 14);
		contentPane.add(lblEmail);
		
		JLabel lblHikingClub = new JLabel("Hiking Club");
		lblHikingClub.setBounds(39, 202, 85, 14);
		contentPane.add(lblHikingClub);
		
		comboBoxClubs = new JComboBox();
		comboBoxClubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nazivKluba = comboBoxClubs.getSelectedItem().toString();
				for (Klub k1 : klubovi) {
					if(nazivKluba.equals(k1.getNaziv())) {
						idKlub =k1.getIdKlub();
						//klub.setNaziv(k1.getNaziv());
						
						break;
					}
				}
			}
		});
		
		comboBoxClubs.setBounds(177, 199, 373, 20);
		contentPane.add(comboBoxClubs);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = tfFirstName.getText();
				String prezime = tfLastName.getText();
				int godiste = Integer.parseInt(tfYearOfBirth.getText().toString());
				String brojLicence = tfLicenseNumber.getText();
				String brojTelefona = tfPhoneNumber.getText();
				String email = tfEmail.getText();
				Vodic vodic = new Vodic(ime, prezime, godiste, brojLicence, brojTelefona, email);
				Klub klub = new Klub();
				klub.setIdKlub(idKlub);
				vodic.setKlub(klub);
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setRequest(vodic);
				transferKlasa.setKontrolerFK(KontrolerFKKonstanta.VODIC);
				transferKlasa.setKontrolerPL(KontrolerPLKonstanta.POST);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearPolja();
			}

			
		});
		btnSave.setBounds(35, 254, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vodic vodic = pokupiPodatkeSaPolja();
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(vodic, KontrolerFKKonstanta.VODIC, KontrolerPLKonstanta.PUT);
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearPolja();
				
				
			}

			
		});
		btnEdit.setBounds(160, 254, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vodic vodic = new Vodic();
				vodic.setIdVodic(idVodic);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(vodic, KontrolerFKKonstanta.VODIC, KontrolerPLKonstanta.DELETE );
				KontrolerFK.getInstanca().execute(transferKlasa);
				postaviPodatkeUTabelu();
				clearPolja();
				
			}
		});
		btnDelete.setBounds(280, 254, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pretraziVodice();
			}

			
		});
		btnSearch.setBounds(436, 300, 187, 23);
		contentPane.add(btnSearch);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(153, 27, 179, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(484, 24, 186, 20);
		contentPane.add(tfLastName);
		tfLastName.setColumns(10);
		
		tfYearOfBirth = new JTextField();
		tfYearOfBirth.setBounds(153, 80, 179, 20);
		contentPane.add(tfYearOfBirth);
		tfYearOfBirth.setColumns(10);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setBounds(153, 139, 179, 20);
		contentPane.add(tfPhoneNumber);
		tfPhoneNumber.setColumns(10);
		
		tfLicenseNumber = new JTextField();
		tfLicenseNumber.setBounds(484, 74, 186, 20);
		contentPane.add(tfLicenseNumber);
		tfLicenseNumber.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(483, 136, 186, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(29, 354, 684, 177);
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
				idVodic = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				tfFirstName.setText(table.getModel().getValueAt(red, 1).toString());
				tfLastName.setText(table.getModel().getValueAt(red, 2).toString());
				tfYearOfBirth.setText(table.getModel().getValueAt(red, 3).toString());
				tfLicenseNumber.setText(table.getModel().getValueAt(red, 4).toString());
				tfPhoneNumber.setText(table.getModel().getValueAt(red, 5).toString());
				tfEmail.setText(table.getModel().getValueAt(red, 6).toString());
				Klub klub1 = new Klub();
				//klub1.setIdKlub(idKlub);
				klub1.setNaziv(table.getModel().getValueAt(red, 7).toString());
				for (Klub klub : klubovi) {
					if (klub.getNaziv().equals(klub1.getNaziv())) {
						comboBoxClubs.getModel().setSelectedItem(klub.getNaziv());
					}
				}
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		rdbtnSearchByName = new JRadioButton("Search by Name");
		rdbtnSearchByName.setBounds(414, 254, 138, 23);
		contentPane.add(rdbtnSearchByName);
		bgPretraga.add(rdbtnSearchByName);
		
		rdbtnSearchByClub = new JRadioButton("Search by Club");
		rdbtnSearchByClub.setBounds(554, 254, 159, 23);
		contentPane.add(rdbtnSearchByClub);
		bgPretraga.add(rdbtnSearchByClub);
		
		JButton btnLoadAll = new JButton("Load All");
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postaviPodatkeUTabelu();
				clearPolja();
			}
		});
		btnLoadAll.setBounds(177, 300, 89, 23);
		contentPane.add(btnLoadAll);
		
		Object [] kolone = {"Guide's ID", "First name", "Last name", "Year of Birth", "License Number", "Phone Numer", "e-mail", "Club"};
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		postaviPodatkeUTabelu();
		popuniComboBoxove();
		
		
	}

	private void postaviPodatkeUTabelu() {
		dtm.setRowCount(0);
		TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(null, KontrolerFKKonstanta.VODIC, KontrolerPLKonstanta.GET);
		KontrolerFK.getInstanca().execute(transferKlasa);
		listaVodica = (List<Vodic>) transferKlasa.getResponse();
		for (Vodic vodic : listaVodica) {
			Object [] red = {vodic.getIdVodic(), vodic.getIme(), vodic.getPrezime(), vodic.getGodiste(), vodic.getBrojLicence(), vodic.getBrojTelefona(), vodic.getEmail(), vodic.getKlub().getNaziv()};
			dtm.addRow(red);
			
		}
		
		
	}

	private void popuniComboBoxove() {
		
		for (Klub klub : klubovi) {
			comboBoxClubs.addItem(klub.getNaziv());
		}
		
	}
	
	private void clearPolja() {
		tfFirstName.setText("");
		tfLastName.setText("");
		tfYearOfBirth.setText("");
		tfLicenseNumber.setText("");
		tfPhoneNumber.setText("");
		tfEmail.setText("");
		
	}
	private Vodic pokupiPodatkeSaPolja() {
		String ime = tfFirstName.getText();
		String prezime = tfLastName.getText();
		int godiste = Integer.parseInt(tfYearOfBirth.getText().toString());
		String brojLicence = tfLicenseNumber.getText();
		String brojTelefona = tfPhoneNumber.getText();
		String email = tfEmail.getText();
		Vodic vodic = new Vodic(ime, prezime, godiste, brojLicence, brojTelefona, email);
		vodic.setIdVodic(idVodic);
		Klub klub = new Klub();
		klub.setIdKlub(idKlub);
		vodic.setKlub(klub);
		
		return vodic;
		
	}
	
	private void pretraziVodice() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		if (rdbtnSearchByName.isSelected()) {
			
			for (Vodic v1 : listaVodica) {
				if(v1.getIme().contains(tfFirstName.getText().toString())) {
					setRed(v1);
					continue;
				}
			}
		} else if (rdbtnSearchByClub.isSelected()) {
			for (Vodic v1 : listaVodica) {
				if (v1.getKlub().getNaziv().equals(comboBoxClubs.getSelectedItem().toString())) {
					setRed(v1);
					continue;
				}
			}
		}
	}

	private void setRed(Vodic v1) {
		// TODO Auto-generated method stub
	
		Object red[] = {v1.getIdVodic(), v1.getIme(), v1.getPrezime(), v1.getGodiste(), v1.getBrojLicence(), v1.getBrojTelefona(), v1.getEmail(), v1.getKlub().getNaziv()};
		dtm.addRow(red);
	}
	
}
