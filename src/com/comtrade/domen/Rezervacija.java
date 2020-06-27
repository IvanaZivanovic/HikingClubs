package com.comtrade.domen;

public class Rezervacija {
	// to do: translate variables from serbian to english 
	private int idRezervacija;
	private Akcija akcija;
	private Planinar planinar;
	
	public Rezervacija(int idRezervacija, Akcija akcija, Planinar planinar) {
		super();
		this.idRezervacija = idRezervacija;
		this.akcija = akcija;
		this.planinar = planinar;
	}
	public Rezervacija(Akcija akcija, Planinar planinar) {
		super();
		this.akcija = akcija;
		this.planinar = planinar;
	}
	public Rezervacija() {
		super();
	}
	public int getIdRezervacija() {
		return idRezervacija;
	}
	public void setIdRezervacija(int idRezervacija) {
		this.idRezervacija = idRezervacija;
	}
	public Akcija getAkcija() {
		return akcija;
	}
	public void setAkcija(Akcija akcija) {
		this.akcija = akcija;
	}
	public Planinar getPlaninar() {
		return planinar;
	}
	public void setPlaninar(Planinar planinar) {
		this.planinar = planinar;
	}
	
	
	

}
