package com.comtrade.proxy;

import javax.swing.JOptionPane;

import com.comtrade.view.MedjuForma;
import com.comtrade.view.RezervacijaForma;

public class ProxyLogin implements Proxy{

	@Override
	public void login(Integer rola) {
		if (rola == null) {
			JOptionPane.showMessageDialog(null, "Takav user ne postoji");
		}else if (rola == 1) {
			MedjuForma medjuForma = new MedjuForma();
			medjuForma.setVisible(true);
		} else if (rola == 2){
			RezervacijaForma rezervacijaForma = new RezervacijaForma();
			rezervacijaForma.setVisible(true);
		} 
	}
	

}
