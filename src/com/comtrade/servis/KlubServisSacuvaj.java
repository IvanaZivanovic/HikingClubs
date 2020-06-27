package com.comtrade.servis;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Adresa;
import com.comtrade.domen.Klub;
import com.comtrade.domen.Kontakt;
import com.comtrade.domen.TransferKlasa;

public class KlubServisSacuvaj extends OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 

	@Override
	public void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa) {
		Klub klub = (Klub) transferKlasa.getRequest();
		Broker broker = new Broker();
		broker.sacuvajKlub(klub);
		
		Klub klubDB = vratiKlub();
		setujIdKluba(klub, klubDB);
		
		upisiAdresu(klub);
		upisiKontakt(klub);
		

	}

	private void upisiKontakt(Klub klub) {
		// TODO Auto-generated method stub
		Kontakt kontakt = klub.getKontakt();
		Broker broker = new Broker();
		broker.upisiKontakt(kontakt);
		
	}

	private void upisiAdresu(Klub klub) {
		// TODO Auto-generated method stub
		Adresa adresa = klub.getAdresa();
		Broker broker = new Broker();
		broker.upisiAdresu(adresa);
		
	}

	private void setujIdKluba(Klub klub, Klub klubDB) {
		// TODO Auto-generated method stub
		Adresa adresa = klub.getAdresa();
		adresa.setKlub(klubDB);
		Kontakt kontakt = klub.getKontakt();
		kontakt.setKlub(klubDB);
		
		
	}

	private Klub vratiKlub() {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		return broker.selectJedan(new Klub());
	}

}
