package com.comtrade.servis;

import com.comtrade.domen.TransferKlasa;
import com.comtrade.konekcija.Konekcija;

public abstract class OpstaSistemskaOperacija {
	// to do: translate variables from serbian to english 
	public void izvrsiSistemskuOperaciju(TransferKlasa transferKlasa) {
		try {
			pokreniTransakciju();
			izvrsiKonkretnuSistemskuOperaciju(transferKlasa);
			potvrdiTransakciju();
			
		} catch (Exception e) {
			ponistiTransakciju();
		} finally {
			zatvoriKonekciju();
		}
	}

	public void pokreniTransakciju() {
		Konekcija.getInstanca().pokreniTransakciju();		
	}
	
	public void potvrdiTransakciju() {
		Konekcija.getInstanca().potvrdiTransakciju();
	}
	
	public void ponistiTransakciju() {
		Konekcija.getInstanca().ponistiTransakciju();
	}
	
	public void zatvoriKonekciju() {
		Konekcija.getInstanca().zatvoriKonekciju();
	}
		
	public abstract void izvrsiKonkretnuSistemskuOperaciju(TransferKlasa transferKlasa);	

}
