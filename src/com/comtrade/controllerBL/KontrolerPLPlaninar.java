package com.comtrade.controllerBL;

import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.servis.OpstaSistemskaOperacija;
import com.comtrade.servis.PlaninarServisDelete;
import com.comtrade.servis.PlaninarServisEdit;
import com.comtrade.servis.PlaninarServisSacuvaj;
import com.comtrade.servis.PlaninarServisVratiSve;

public class KontrolerPLPlaninar implements KontrolerCommandBase {
	// to do: translate variables from serbian to english 

	@Override
	public void execute(TransferKlasa transferKlasa) {
		// TODO Auto-generated method stub
		OpstaSistemskaOperacija operacija = null;
		if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST) {
			operacija = new PlaninarServisSacuvaj();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.GET) {
			operacija = new PlaninarServisVratiSve();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.DELETE) {
			operacija = new PlaninarServisDelete();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.PUT) {
			operacija = new PlaninarServisEdit();
		}
		
		operacija.izvrsiSistemskuOperaciju(transferKlasa);
	}

}
