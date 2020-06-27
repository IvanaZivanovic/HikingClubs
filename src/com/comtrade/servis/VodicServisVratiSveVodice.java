package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.Vodic;

public class VodicServisVratiSveVodice extends OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		transferKlasa.setResponse(broker.selectAllForTable(new Vodic()));

	}

}
