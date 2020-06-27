package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface OpstiDomen {
	// to do: translate variables from serbian to english 
	String vratiNazivTabele();
	String vratiNaziveKolona();
	String vratiVrednosti();
	public PreparedStatement sacuvaj(PreparedStatement preparedStatement);
	List<OpstiDomen>selectZaTabelu(ResultSet resultSet);
	String vratiId();
	String vratiUpdate();
	
	PreparedStatement setujVrednostiZaUpdate(PreparedStatement preparedStatement);
	

}
