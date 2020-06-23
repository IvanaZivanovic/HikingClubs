package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Rezervacija;
import com.comtrade.domen.TransferKlasa;

public class RezervacijaServisSacuvaj extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Rezervacija rezervacija = (Rezervacija) transferKlasa.getRequest();
		broker.sacuvajRezervaciju(rezervacija);

	}

}
