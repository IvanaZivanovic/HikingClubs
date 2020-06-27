package com.comtrade.controllerFC;

import com.comtrade.controllerBL.KontrolerCommandBase;
import com.comtrade.controllerBL.KontrolerPLAkcija;
import com.comtrade.controllerBL.KontrolerPLKlub;
import com.comtrade.controllerBL.KontrolerPLPlaninar;
import com.comtrade.controllerBL.KontrolerPLRezervacija;
import com.comtrade.controllerBL.KontrolerPLUser;
import com.comtrade.controllerBL.KontrolerPLVodic;
import com.comtrade.domen.TransferKlasa;

public class KontrolerFK {
	// to do: translate variables from serbian to english 
	
	private static KontrolerFK kontrolerFK;
	private KontrolerFK() {
		
	}
	
	public static KontrolerFK getInstanca() {
		if(kontrolerFK == null) {
			kontrolerFK = new KontrolerFK();
		}
		return kontrolerFK;
	}
	
	public void execute(TransferKlasa transferKlasa) {
		KontrolerCommandBase commandBase = null;
		switch (transferKlasa.getKontrolerFK()) {
		case USER:
			commandBase = new KontrolerPLUser();
			break;
		case KLUB:
			commandBase = new KontrolerPLKlub();
			break;
		case VODIC:
			commandBase = new KontrolerPLVodic();
			break;
		case PLANINAR:
			commandBase = new KontrolerPLPlaninar();
			break;
		case AKCIJA:
			commandBase = new KontrolerPLAkcija();
			break;
		case REZERVACIJA:
			commandBase = new KontrolerPLRezervacija();
					
		default:
			break;
		}
		commandBase.execute(transferKlasa);

}
}
