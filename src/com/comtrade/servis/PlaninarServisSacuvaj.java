package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Planinar;
import com.comtrade.domen.TransferKlasa;

public class PlaninarServisSacuvaj extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Planinar planinar = (Planinar) transferKlasa.getRequest();
		broker.savePlaninar(planinar);
	}

}
