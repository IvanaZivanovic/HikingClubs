package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Klub implements OpstiDomen {
	// to do: translate variables from serbian to english 
	private int idKlub;
	private String naziv;
	private String pib;
	private Adresa adresa;
	private Kontakt kontakt;
	
	public Klub(int idKlub, String naziv, String pib) {
		super();
		this.idKlub = idKlub;
		this.naziv = naziv;
		this.pib = pib;
	}
	public Klub(String naziv, String pib) {
		super();
		this.naziv = naziv;
		this.pib = pib;
	}
	public Klub() {
		super();
	}
	
	
	public Klub(Adresa adresa, Kontakt kontakt) {
		super();
		this.adresa = adresa;
		this.kontakt = kontakt;
	}
	public int getIdKlub() {
		return idKlub;
	}
	public void setIdKlub(int idKlub) {
		this.idKlub = idKlub;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public Kontakt getKontakt() {
		return kontakt;
	}
	public void setKontakt(Kontakt kontakt) {
		this.kontakt = kontakt;
	}
	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " `club` ";
	}
	@Override
	public String vratiNaziveKolona() {
		// TODO Auto-generated method stub
		return " (`name`, `tin`) ";
	}
	@Override
	public String vratiVrednosti() {
		// TODO Auto-generated method stub
		return " (?, ?) ";
	}
	@Override
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, naziv);
			preparedStatement.setString(2, pib);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return preparedStatement;
	}
	@Override
	public List<OpstiDomen> selectZaTabelu(ResultSet resultSet) {
		// TODO Auto-generated method stub+
		List<OpstiDomen>list = new ArrayList<OpstiDomen>();
		int idKlub = 0;
		try {
			while(resultSet.next()) {
				Klub klub = new Klub();
				klub.setIdKlub(resultSet.getInt("id_club"));
				klub.setNaziv(resultSet.getString(("name")));
				list.add(klub);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public PreparedStatement setujVrednostiZaUpdate(PreparedStatement preparedStatement) {
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
	
	
	
	

}
