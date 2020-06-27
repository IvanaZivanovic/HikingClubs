package com.comtrade.servis;

import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.Vodic;

public class VodicServisGetJedanKlub extends OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Vodic vodic = (Vodic) transferKlasa.getRequest();
		transferKlasa.setResponse(broker.vratiVodiceKluba(vodic));
		List<Vodic> vodiciJednogKluba = (List<Vodic>) transferKlasa.getResponse();

	}

}
