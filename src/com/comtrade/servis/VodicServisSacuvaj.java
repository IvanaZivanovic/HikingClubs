package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.Vodic;

public class VodicServisSacuvaj extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		Vodic vodic = (Vodic) transferKlasa.getRequest();
		Broker broker = new Broker();
		broker.save(vodic);
	}

}
