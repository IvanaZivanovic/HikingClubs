package com.comtrade.controlerPL;

import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.servis.AkcijaServisDelete;
import com.comtrade.servis.AkcijaServisIzmeni;
import com.comtrade.servis.AkcijaServisSacuvaj;
import com.comtrade.servis.AkcijaServisVratiSve;
import com.comtrade.servis.OpstaSistemskaOperacija;
import com.toedter.calendar.IDateEditor;

public class KontrolerPLAkcija implements KontrolerCommandBase {

	@Override
	public void execute(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		OpstaSistemskaOperacija operacija = null;
		if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST){
			operacija = new AkcijaServisSacuvaj();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET){
			operacija = new AkcijaServisVratiSve();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.DELETE) {
			operacija = new AkcijaServisDelete();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.PUT) {
			operacija = new AkcijaServisIzmeni();
		}
			operacija.izvrsiSistemskuOperaciju(transferKlasa);
	}

}
