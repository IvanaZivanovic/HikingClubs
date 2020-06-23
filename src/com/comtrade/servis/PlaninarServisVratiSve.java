package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Planinar;
import com.comtrade.domen.TransferKlasa;

public class PlaninarServisVratiSve extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		transferKlasa.setResponse(broker.selectSvePlaninare(new Planinar()));

	}

}
