package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.Vodic;

public class VodicServisUpdate extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Vodic vodic = (Vodic) transferKlasa.getRequest();
		broker.izmeniVodica(vodic);

	}

}
