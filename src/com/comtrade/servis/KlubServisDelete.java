package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Klub;
import com.comtrade.domen.TransferKlasa;

public class KlubServisDelete extends OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Klub klub =  (Klub) transferKlasa.getRequest();
		Broker broker = new Broker();
		broker.deleteKlub(klub);
	}

}
