package com.comtrade.domen;

import java.time.LocalDate;

public class Akcija {
	private int idAkcija;
	private String destinacija;
	private LocalDate datumAkcije;
	private String tipAKcije;
	private double cena;
	private String linkAkcije;
	private Vodic vodic;
	private Klub klub;
	
	public Akcija(int idAkcija, String destinacija, LocalDate datumAkcije, String tipAKcije, double cena,
			String linkAkcije, Vodic vodic, Klub klub) {
		super();
		this.idAkcija = idAkcija;
		this.destinacija = destinacija;
		this.datumAkcije = datumAkcije;
		this.tipAKcije = tipAKcije;
		this.cena = cena;
		this.linkAkcije = linkAkcije;
		this.vodic = vodic;
		this.klub = klub;
	}

	public Akcija() {
		super();
	}

	public Akcija(String destinacija, LocalDate datumAkcije, String tipAKcije, double cena, String linkAkcije,
			Vodic vodic, Klub klub) {
		super();
		this.destinacija = destinacija;
		this.datumAkcije = datumAkcije;
		this.tipAKcije = tipAKcije;
		this.cena = cena;
		this.linkAkcije = linkAkcije;
		this.vodic = vodic;
		this.klub = klub;
	}
	
	

	public Akcija(String destinacija, LocalDate datumAkcije, String tipAKcije, double cena, String linkAkcije) {
		super();
		this.destinacija = destinacija;
		this.datumAkcije = datumAkcije;
		this.tipAKcije = tipAKcije;
		this.cena = cena;
		this.linkAkcije = linkAkcije;
	}

	public int getIdAkcija() {
		return idAkcija;
	}

	public void setIdAkcija(int idAkcija) {
		this.idAkcija = idAkcija;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public LocalDate getDatumAkcije() {
		return datumAkcije;
	}

	public void setDatumAkcije(LocalDate datumAkcije) {
		this.datumAkcije = datumAkcije;
	}

	public String getTipAKcije() {
		return tipAKcije;
	}

	public void setTipAKcije(String tipAKcije) {
		this.tipAKcije = tipAKcije;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getLinkAkcije() {
		return linkAkcije;
	}

	public void setLinkAkcije(String linkAkcije) {
		this.linkAkcije = linkAkcije;
	}

	public Vodic getVodic() {
		return vodic;
	}

	public void setVodic(Vodic vodic) {
		this.vodic = vodic;
	}

	public Klub getKlub() {
		return klub;
	}

	public void setKlub(Klub klub) {
		this.klub = klub;
	}
	
	

}
