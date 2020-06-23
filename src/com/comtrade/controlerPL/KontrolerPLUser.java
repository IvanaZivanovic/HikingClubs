package com.comtrade.controlerPL;

import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.servis.OpstaSistemskaOperacija;
import com.comtrade.servisuser.UserServisLogovanje;
import com.comtrade.servisuser.UserServisRegister;


public class KontrolerPLUser implements KontrolerCommandBase{

	@Override
	public void execute(TransferKlasa transferKlasa) {
		OpstaSistemskaOperacija operacija = null;		
		if(transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST) {
			operacija = new UserServisLogovanje();
		} else if (transferKlasa.getKontrolerPL() == KontrolerPLKonstanta.POST_USER) {
			operacija = new UserServisRegister();
		} 
		operacija.izvrsiSistemskuOperaciju(transferKlasa);
	}
	

}
