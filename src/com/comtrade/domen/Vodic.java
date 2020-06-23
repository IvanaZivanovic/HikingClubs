package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Vodic implements OpstiDomen{
	private int idVodic;
	private String ime;
	private String prezime;
	private int godiste;
	private String brojLicence;
	private String brojTelefona;
	private String email;
	private Klub klub;
	
		public Vodic(int idVodic, String ime, String prezime, int godiste, String brojLicence, String brojTelefona,
			String email, Klub klub) {
		super();
		this.idVodic = idVodic;
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
		this.brojLicence = brojLicence;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.klub = klub;
	}
		
		

	public Vodic() {
			super();
		}

	

	public Vodic(String ime, String prezime, int godiste, String brojLicence, String brojTelefona, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
		this.brojLicence = brojLicence;
		this.brojTelefona = brojTelefona;
		this.email = email;
	}

	public int getIdVodic() {
		return idVodic;
	}

	public void setIdVodic(int idVodic) {
		this.idVodic = idVodic;
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

	public String getBrojLicence() {
		return brojLicence;
	}

	public void setBrojLicence(String brojLicence) {
		this.brojLicence = brojLicence;
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
		try {
			preparedStatement.setString(1, ime);
			preparedStatement.setString(2, prezime);
			preparedStatement.setInt(3, godiste);
			preparedStatement.setString(4, brojLicence);
			preparedStatement.setString(5, brojTelefona);
			preparedStatement.setString(6, email);
			preparedStatement.setInt(7, klub.getIdKlub());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preparedStatement;
	}

	@Override
	public List<OpstiDomen> selectZaTabelu(ResultSet resultSet) {
		
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PreparedStatement setujVrednostiZaUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, ime);
			preparedStatement.setString(2, prezime);
			preparedStatement.setInt(3, godiste);
			preparedStatement.setString(4, brojLicence);
			preparedStatement.setString(5, brojTelefona);
			preparedStatement.setString(6, email);
			preparedStatement.setInt(7, klub.getIdKlub());
			preparedStatement.setInt(8, idVodic);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return preparedStatement;
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
