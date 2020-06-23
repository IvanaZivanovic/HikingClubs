package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Adresa implements OpstiDomen{
	
	private int id_adresa;
	private String mesto;
	private int postanski_broj;
	private String ulica;
	private String broj;
	private Klub klub;
	
	
	public Adresa(int id_adresa, String mesto, int postanski_broj, String ulica, String broj) {
		super();
		this.id_adresa = id_adresa;
		this.mesto = mesto;
		this.postanski_broj = postanski_broj;
		this.ulica = ulica;
		this.broj = broj;
	
	}
	public Adresa() {
		super();
	}
	
	
	public Adresa(String mesto) {
		super();
		this.mesto = mesto;
	}
	public Adresa(String mesto, int postanski_broj, String ulica, String broj) {
		super();
		this.mesto = mesto;
		this.postanski_broj = postanski_broj;
		this.ulica = ulica;
		this.broj = broj;
	}
	public int getId_adresa() {
		return id_adresa;
	}
	public void setId_adresa(int id_adresa) {
		this.id_adresa = id_adresa;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public int getPostanski_broj() {
		return postanski_broj;
	}
	public void setPostanski_broj(int postanski_broj) {
		this.postanski_broj = postanski_broj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
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
		return " `adresa` ";
	}
	@Override
	public String vratiNaziveKolona() {
		// TODO Auto-generated method stub
		return " (`mesto`, `postanski_broj`, `ulica`, `broj`, `id_klub`)";
	}
	@Override
	public String vratiVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?,?,?,?) ";
	}
	@Override
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, mesto);
			preparedStatement.setInt(2, postanski_broj);
			preparedStatement.setString(3, ulica);
			preparedStatement.setString(4, broj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	@Override
	public List<OpstiDomen> selectZaTabelu(ResultSet resultSet) {
		// TODO Auto-generated method stub
		List<OpstiDomen>list = new ArrayList<OpstiDomen>();
		try {
			while(resultSet.next()) {
				Adresa adresa = new Adresa();
				adresa.setMesto(resultSet.getString("mesto"));
				list.add(adresa);
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