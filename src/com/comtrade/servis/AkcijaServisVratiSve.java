package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Akcija;
import com.comtrade.domen.TransferKlasa;

public class AkcijaServisVratiSve extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		transferKlasa.setResponse(broker.vratiListuAkcija(new Akcija()));
	}

}
