package com.comtrade.domen;

public class TransferKlasa {
	// to do: translate variables from serbian to english 
	private Object request;
	private Object response;
	private String message;
	private KontrolerFKKonstanta kontrolerFK;
	private KontrolerPLKonstanta kontrolerPL;
	
	public Object getRequest() {
		return request;
	}
	public void setRequest(Object request) {
		this.request = request;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public KontrolerFKKonstanta getKontrolerFK() {
		return kontrolerFK;
	}
	public void setKontrolerFK(KontrolerFKKonstanta kontrolerFK) {
		this.kontrolerFK = kontrolerFK;
	}
	public KontrolerPLKonstanta getKontrolerPL() {
		return kontrolerPL;
	}
	public void setKontrolerPL(KontrolerPLKonstanta kontrolerPL) {
		this.kontrolerPL = kontrolerPL;
	}

	public static TransferKlasa kreirajRequest(Object request, KontrolerFKKonstanta kontrolerFKKonstanta, KontrolerPLKonstanta kontrolerPLKonstanta) {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setRequest(request);
		transferKlasa.setKontrolerFK(kontrolerFKKonstanta);
		transferKlasa.setKontrolerPL(kontrolerPLKonstanta);
		return transferKlasa;
	}

}
