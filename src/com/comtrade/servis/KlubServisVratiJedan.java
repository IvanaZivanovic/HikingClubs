package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Klub;
import com.comtrade.domen.TransferKlasa;

public class KlubServisVratiJedan extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		transferKlasa.setResponse(broker.selectJedan(new Klub()));
		
//		Klub klub = (Klub) transferKlasa.getRequest();
		
	//	transferKlasa.setResponse(broker.selectJedan(new Klub()));
	}

}
