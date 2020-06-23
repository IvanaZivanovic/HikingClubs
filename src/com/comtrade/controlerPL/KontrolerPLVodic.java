package com.comtrade.controlerPL;

import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.servis.OpstaSistemskaOperacija;
import com.comtrade.servis.VodicServisGetJedanKlub;
import com.comtrade.servis.VodicServisObrisi;
import com.comtrade.servis.VodicServisSacuvaj;
import com.comtrade.servis.VodicServisUpdate;
import com.comtrade.servis.VodicServisVratiSveVodice;


public class KontrolerPLVodic implements KontrolerCommandBase {

	@Override
	public void execute(TransferKlasa transferKlasa) {
		OpstaSistemskaOperacija operacija = null;
		if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST) {
			operacija = new VodicServisSacuvaj();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET) {
			operacija = new VodicServisVratiSveVodice();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.PUT) {
			operacija = new VodicServisUpdate();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.DELETE) {
			operacija = new VodicServisObrisi();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET_JEDAN) {
			operacija = new VodicServisGetJedanKlub();
		}
		
		operacija.izvrsiSistemskuOperaciju(transferKlasa);
	}

}
