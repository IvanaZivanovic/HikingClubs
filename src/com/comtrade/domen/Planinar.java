package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class Planinar implements OpstiDomen{
	// to do: translate variables from serbian to english 
	private int idPlaninar;
	private String ime;
	private String prezime;
	private int godiste;
	private String brojClanskeKarte;
	private LocalDate istekClanarine;
	private String brojTelefona;
	private String email;
	private Klub klub;
	
	public Planinar(int idPlaninar, String ime, String prezime, int godiste, String brojClanskeKarte,
			LocalDate istekClanarine, String brojTelefona, String email, Klub klub) {
		super();
		this.idPlaninar = idPlaninar;
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
		this.brojClanskeKarte = brojClanskeKarte;
		this.istekClanarine = istekClanarine;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.klub = klub;
	}
	
	public Planinar(String ime, String prezime, int godiste, String brojClanskeKarte, LocalDate istekClanarine,
			String brojTelefona, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
		this.brojClanskeKarte = brojClanskeKarte;
		this.istekClanarine = istekClanarine;
		this.brojTelefona = brojTelefona;
		this.email = email;
	}

	public Planinar() {
		super();
	}

	public int getIdPlaninar() {
		return idPlaninar;
	}

	public void setIdPlaninar(int idPlaninar) {
		this.idPlaninar = idPlaninar;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	public LocalDate getIstekClanarine() {
		return istekClanarine;
	}

	public void setIstekClanarine(LocalDate istekClanarine) {
		this.istekClanarine = istekClanarine;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Klub getKlub() {
		return klub;
	}

	public void setKlub(Klub klub) {
		this.klub = klub;
	}

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vratiNaziveKolona() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vratiVrednosti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpstiDomen> selectZaTabelu(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vratiId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vratiUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement setujVrednostiZaUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
