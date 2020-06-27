package com.comtrade.proxy;

import javax.swing.JOptionPane;

import com.comtrade.view.MidFrame;
import com.comtrade.view.BookingFrame;

public class ProxyLogin implements Proxy{
	// to do: translate variables from serbian to english 

	@Override
	public void login(Integer rola) {
		if (rola == null) {
			JOptionPane.showMessageDialog(null, "User does not exist");
		}else if (rola == 1) {
			MidFrame medjuForma = new MidFrame();
			medjuForma.setVisible(true);
		} else if (rola == 2){
			BookingFrame rezervacijaForma = new BookingFrame();
			rezervacijaForma.setVisible(true);
		} 
	}
	

}
