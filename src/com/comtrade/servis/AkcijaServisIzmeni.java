package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Akcija;
import com.comtrade.domen.TransferKlasa;

public class AkcijaServisIzmeni extends OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Akcija akcija = (Akcija) transferKlasa.getRequest();
		broker.izmeniAkciju(akcija);

	}

}
