package com.comtrade.servisuser;


import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;
import com.comtrade.servis.OpstaSistemskaOperacija;

public class UserServisLogovanje extends OpstaSistemskaOperacija{

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		User user = (User) transferKlasa.getRequest();
		Broker broker = new Broker();
		Integer rola = broker.login(user);
		transferKlasa.setResponse(rola);
		
	}
	

}
