package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MidFrame extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MidFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHikingClubs = new JButton("Hiking Clubs");
		btnHikingClubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClubsFrame klubForma = new ClubsFrame();
				klubForma.setVisible(true);
			}
		});
		btnHikingClubs.setBounds(65, 53, 134, 23);
		contentPane.add(btnHikingClubs);
		
		JButton btnTours = new JButton("Tours");
		btnTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToursFrame akcijeForma = new ToursFrame();
				akcijeForma.setVisible(true);
			}
		});
		btnTours.setBounds(241, 53, 134, 23);
		contentPane.add(btnTours);
		
		JButton btnHikingGuides = new JButton("Hiking Guides");
		btnHikingGuides.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuidesFrame vodicForma = new GuidesFrame();
				vodicForma.setVisible(true);
			}
		});
		btnHikingGuides.setBounds(65, 136, 134, 23);
		contentPane.add(btnHikingGuides);
		
		JButton btnHikers = new JButton("Hikers");
		btnHikers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HikersFrame planinarForma = new HikersFrame();
				planinarForma.setVisible(true);
			}
		});
		btnHikers.setBounds(241, 136, 134, 23);
		contentPane.add(btnHikers);
	}
}
