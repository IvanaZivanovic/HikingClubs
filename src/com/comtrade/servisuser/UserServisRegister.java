package com.comtrade.servisuser;

import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;

import com.comtrade.servis.OpstaSistemskaOperacija;

public class UserServisRegister extends OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		User user = (User) transferKlasa.getRequest();
		Broker broker = new Broker();
		broker.saveUser(user);
		
	}
	

}
