package com.comtrade.controlerFK;

import com.comtrade.controlerPL.KontrolerCommandBase;
import com.comtrade.controlerPL.KontrolerPLAkcija;
import com.comtrade.controlerPL.KontrolerPLKlub;
import com.comtrade.controlerPL.KontrolerPLPlaninar;
import com.comtrade.controlerPL.KontrolerPLRezervacija;
import com.comtrade.controlerPL.KontrolerPLUser;
import com.comtrade.controlerPL.KontrolerPLVodic;
import com.comtrade.domen.TransferKlasa;

public class KontrolerFK {
	
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
