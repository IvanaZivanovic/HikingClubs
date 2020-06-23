package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Akcija;
import com.comtrade.domen.TransferKlasa;

public class AkcijaServisDelete extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Akcija akcija = (Akcija) transferKlasa.getRequest();
		broker.deleteAkciju(akcija);

	}

}
