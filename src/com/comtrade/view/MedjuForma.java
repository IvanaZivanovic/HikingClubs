package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedjuForma extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MedjuForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHikingClubs = new JButton("Hiking Clubs");
		btnHikingClubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KlubForma klubForma = new KlubForma();
				klubForma.setVisible(true);
			}
		});
		btnHikingClubs.setBounds(65, 53, 134, 23);
		contentPane.add(btnHikingClubs);
		
		JButton btnActivites = new JButton("Activities");
		btnActivites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AkcijeForma akcijeForma = new AkcijeForma();
				akcijeForma.setVisible(true);
			}
		});
		btnActivites.setBounds(241, 53, 134, 23);
		contentPane.add(btnActivites);
		
		JButton btnHikingGuides = new JButton("Hiking Guides");
		btnHikingGuides.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VodicForma vodicForma = new VodicForma();
				vodicForma.setVisible(true);
			}
		});
		btnHikingGuides.setBounds(65, 136, 134, 23);
		contentPane.add(btnHikingGuides);
		
		JButton btnHikers = new JButton("Hikers");
		btnHikers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaninarForma planinarForma = new PlaninarForma();
				planinarForma.setVisible(true);
			}
		});
		btnHikers.setBounds(241, 136, 134, 23);
		contentPane.add(btnHikers);
	}
}
