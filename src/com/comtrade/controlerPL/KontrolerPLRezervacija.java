package com.comtrade.controlerPL;

import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.servis.OpstaSistemskaOperacija;
import com.comtrade.servis.RezervacijaServisSacuvaj;
import com.comtrade.servis.RezervacijaServisVratiListu;

public class KontrolerPLRezervacija implements KontrolerCommandBase {

	@Override
	public void execute(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		OpstaSistemskaOperacija operacija = null;
		if(transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST) {
			operacija = new RezervacijaServisSacuvaj();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET) {
			operacija = new RezervacijaServisVratiListu();
		}
		operacija.izvrsiSistemskuOperaciju(transferKlasa);
	}

}
