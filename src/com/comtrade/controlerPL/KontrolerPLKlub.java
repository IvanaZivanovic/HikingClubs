package com.comtrade.controlerPL;

import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.servis.KlubServisDelete;
import com.comtrade.servis.KlubServisIzmeni;
import com.comtrade.servis.KlubServisSacuvaj;
import com.comtrade.servis.KlubServisVratiJedan;
import com.comtrade.servis.KlubServisVratiListuKlubova;
import com.comtrade.servis.OpstaSistemskaOperacija;

public class KontrolerPLKlub implements KontrolerCommandBase {

	@Override
	public void execute(TransferKlasa transferKlasa) {
		OpstaSistemskaOperacija operacija = null;
		if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST) {
			operacija = new KlubServisSacuvaj();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET) {
			operacija = new KlubServisVratiListuKlubova();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.DELETE) {
			operacija = new KlubServisDelete();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET_JEDAN) {
			operacija = new KlubServisVratiJedan();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.PUT) {
			operacija = new KlubServisIzmeni();
		}
		operacija.izvrsiSistemskuOperaciju(transferKlasa);

	}

}
