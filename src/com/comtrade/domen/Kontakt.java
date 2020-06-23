package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kontakt implements OpstiDomen{
	private int idKontakt;
	private String brojTelefona;
	private String email;
	private String webSajt;
	private Klub klub;
	
	

	public Kontakt(int idKontakt, String brojTelefona, String email, String webSajt) {
		super();
		this.idKontakt = idKontakt;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.webSajt = webSajt;
			}
	public Kontakt() {
		super();
	}
	public Kontakt(String brojTelefona, String email, String webSajt) {
		super();
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.webSajt = webSajt;
	}
	public int getIdKontakt() {
		return idKontakt;
	}
	public void setIdKontakt(int idKontakt) {
		this.idKontakt = idKontakt;
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
	public String getWebSajt() {
		return webSajt;
	}
	public void setWebSajt(String webSajt) {
		this.webSajt = webSajt;
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
		return " `kontakt` ";
	}
	@Override
	public String vratiNaziveKolona() {
		// TODO Auto-generated method stub
		return " (`broj_telefona`, `email`, `web_sajt`, `id_klub`) ";
	}
	@Override
	public String vratiVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?,?,?) ";
	}
	@Override
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, brojTelefona);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, webSajt);
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
				Kontakt kontakt = new Kontakt();
				kontakt.setBrojTelefona(resultSet.getString("broj_telefona"));
				kontakt.setEmail(resultSet.getString("email"));
				kontakt.setWebSajt(resultSet.getString("web_sajt"));
				list.add(kontakt);
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
