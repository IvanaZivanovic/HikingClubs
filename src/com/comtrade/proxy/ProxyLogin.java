package com.comtrade.proxy;

import javax.swing.JOptionPane;

import com.comtrade.view.MidFrame;
import com.comtrade.view.BookingFrame;

public class ProxyLogin implements Proxy{

	@Override
	public void login(Integer rola) {
		if (rola == null) {
			JOptionPane.showMessageDialog(null, "Takav user ne postoji");
		}else if (rola == 1) {
			MidFrame medjuForma = new MidFrame();
			medjuForma.setVisible(true);
		} else if (rola == 2){
			BookingFrame rezervacijaForma = new BookingFrame();
			rezervacijaForma.setVisible(true);
		} 
	}
	

}
