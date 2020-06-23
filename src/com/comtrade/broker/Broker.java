package com.comtrade.broker;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.comtrade.domen.Adresa;
import com.comtrade.domen.Akcija;
import com.comtrade.domen.Klub;
import com.comtrade.domen.Kontakt;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.domen.Planinar;
import com.comtrade.domen.Rezervacija;
import com.comtrade.domen.User;
import com.comtrade.domen.Vodic;
import com.comtrade.konekcija.Konekcija;

public class Broker {
	
	public Integer login(User user) {
		String sql = "select * from users INNER join user_role on users.id_user = user_role.id_user where users.username = ? and users.password = ?";
		Integer rola = null;
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				rola = resultSet.getInt("id_role");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rola;
	}

	public void sacuvajKlub(Klub klub) {
		String sql ="INSERT INTO " + klub.vratiNazivTabele() + " " + klub.vratiNaziveKolona() + " VALUES " + klub.vratiVrednosti();
		//ResultSet resultSet = null;
		//int idKlub = 0;
		try {
			
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			klub.sacuvaj(preparedStatement);
			preparedStatement.execute();
			
			/*String sqlId = "SELECT `id_klub` as id_klub FROM `klub` WHERE naziv = ?";
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlId);
			preparedStatement.setString(1, klub.getNaziv());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				idKlub = resultSet.getInt("id_klub");
			}
			
			String sqlAdresa =  "INSERT INTO " + klub.getAdresa().vratiNazivTabele() + " " + klub.getAdresa().vratiNaziveKolona()+ " VALUES " + klub.getAdresa().vratiVrednosti();
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlAdresa);
			klub.getAdresa().sacuvaj(preparedStatement);
			preparedStatement.setInt(5, idKlub);
			preparedStatement.execute();
			
			String sqlKontakt = "INSERT INTO " + klub.getKontakt().vratiNazivTabele()+ " " + klub.getKontakt().vratiNaziveKolona() + " VALUES " + klub.getKontakt().vratiVrednosti();
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlKontakt);
			klub.getKontakt().sacuvaj(preparedStatement);
			preparedStatement.setInt(4, idKlub);
			preparedStatement.execute();*/
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Klub> selectAll(Klub klub) {
		List<Klub>list = new ArrayList<Klub>();
		String sql = "select * from klub INNER join adresa on klub.id_klub = adresa.id_klub INNER join kontakt on kontakt.id_klub = klub.id_klub";
		
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Klub klub1 = new Klub();
				Kontakt kontakt = new Kontakt();
				Adresa adresa = new Adresa();
				
				klub1.setIdKlub(resultSet.getInt("id_klub"));
				klub1.setNaziv(resultSet.getString("naziv"));
				klub1.setPib(resultSet.getString("pib_broj"));
				
				adresa.setMesto(resultSet.getString("mesto"));
				adresa.setPostanski_broj(resultSet.getInt("postanski_broj"));
				adresa.setUlica(resultSet.getString("ulica"));
				adresa.setBroj(resultSet.getString("broj"));
												
				kontakt.setBrojTelefona(resultSet.getString("broj_telefona"));
				kontakt.setEmail(resultSet.getString("email"));
				kontakt.setWebSajt(resultSet.getString("web_sajt"));
				klub1.setKontakt(kontakt);
				klub1.setAdresa(adresa);
								
				list.add(klub1);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return list;
		// TODO Auto-generated method stub
		
	}

	public void deleteKlub(Klub klub) {
		String sql = "delete from adresa where id_klub = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, klub.getIdKlub());
			preparedStatement.execute();
			
			String sqlKontakt = "delete from kontakt where id_klub = ?";
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlKontakt);
			preparedStatement.setInt(1, klub.getIdKlub());
			preparedStatement.execute();
			
			String sqlKlub = "delete from klub where id_klub = ?";
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlKlub);
			preparedStatement.setInt(1, klub.getIdKlub());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Klub selectJedan(Klub klub) {
		String sql = "select max(id_klub) as id from klub";
		Klub klub1 = new Klub();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idKlub = resultSet.getInt("id");
				klub1.setIdKlub(idKlub);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return klub1;
		
	
	}

	public void izmeni(Klub klub) {
		String sql = " update klub INNER join adresa on adresa.id_klub = klub.id_klub INNER JOIN kontakt on kontakt.id_klub = klub.id_klub set klub.naziv = ?, klub.pib_broj = ?, adresa.mesto = ?, adresa.postanski_broj = ?, adresa.ulica = ?, adresa.broj = ?, kontakt.broj_telefona = ?, kontakt.email = ?, kontakt.web_sajt = ? where klub.id_klub = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, klub.getNaziv());
			preparedStatement.setString(2, klub.getPib());
			preparedStatement.setString(3, klub.getAdresa().getMesto());
			preparedStatement.setInt(4, klub.getAdresa().getPostanski_broj());
			preparedStatement.setString(5, klub.getAdresa().getUlica());
			preparedStatement.setString(6, klub.getAdresa().getBroj());
			preparedStatement.setString(7, klub.getKontakt().getBrojTelefona());
			preparedStatement.setString(8, klub.getKontakt().getEmail());
			preparedStatement.setString(9, klub.getKontakt().getWebSajt());
			preparedStatement.setInt(10, klub.getIdKlub());
			preparedStatement.execute();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void save(OpstiDomen opstiDomen) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `vodic`(`ime`, `prezime`, `godiste`, `broj_licence`, `broj_telefona`, `email`, `id_klub`) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			opstiDomen.sacuvaj(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<Vodic> selectAllForTable(Vodic vodic) {
		String sql = "select * from vodic INNER JOIN klub on vodic.id_klub = klub.id_klub";
		List<Vodic>vodici = new ArrayList<Vodic>();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Vodic vodic1 = new Vodic();
				Klub klub = new Klub();
				vodic1.setIdVodic(resultSet.getInt("id_vodic"));
				vodic1.setIme(resultSet.getString("ime"));
				vodic1.setPrezime(resultSet.getString("prezime"));
				vodic1.setGodiste(resultSet.getInt("godiste"));
				vodic1.setBrojLicence(resultSet.getString("broj_licence"));
				vodic1.setBrojTelefona(resultSet.getString("broj_telefona"));
				vodic1.setEmail(resultSet.getString("email"));
				klub.setNaziv(resultSet.getString("naziv"));
				klub.setIdKlub(resultSet.getInt("id_klub"));
				vodic1.setKlub(klub);
				
				vodici.add(vodic1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return vodici;
	}

	public void izmeniVodica(OpstiDomen opstiDomen) {
		String sql = "UPDATE `vodic` SET `ime`=?,`prezime`=?,`godiste`=?,`broj_licence`=?,`broj_telefona`=?,`email`=?,`id_klub`=? WHERE id_vodic = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			opstiDomen.setujVrednostiZaUpdate(preparedStatement);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void obrisiVodica(Vodic vodic) {
		// TODO Auto-generated method stub
		String sql = "Delete from vodic where id_vodic = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, vodic.getIdVodic());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void savePlaninar(Planinar planinar) {
		// TODO Auto-generated method stub
		String sql = "insert into `planinar` (`ime`, `prezime`, `godiste`, `broj_clanske_karte`, `clanarina`, `broj_telefona`, `email`, `id_klub`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, planinar.getIme());
			preparedStatement.setString(2, planinar.getPrezime());
			preparedStatement.setInt(3, planinar.getGodiste());
			preparedStatement.setString(4, planinar.getBrojClanskeKarte());
			preparedStatement.setDate(5, Date.valueOf(planinar.getIstekClanarine()));
			preparedStatement.setString(6, planinar.getBrojTelefona());
			preparedStatement.setString(7, planinar.getEmail());
			preparedStatement.setInt(8, planinar.getKlub().getIdKlub());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Planinar> selectSvePlaninare(Planinar planinar) {
		List<Planinar> listPlaninara = new ArrayList<Planinar>();
		String sql = "select * from planinar INNER JOIN klub on planinar.id_klub = klub.id_klub";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String ime = resultSet.getString("ime");
				String prezime = resultSet.getString("prezime");
				int godiste = resultSet.getInt("godiste");
				String brojClKarte = resultSet.getString("broj_clanske_karte");
				LocalDate istekClanarine = resultSet.getDate("clanarina").toLocalDate();
				String brojTelefona = resultSet.getString("broj_telefona");
				String email = resultSet.getString("email");
				int idKlub = resultSet.getInt("id_klub");
				int idPlaninar = resultSet.getInt("id_planinar");
				String nazivKluba = resultSet.getString("naziv");
				Klub klub = new Klub();
				klub.setIdKlub(idKlub);
				klub.setNaziv(nazivKluba);
				Planinar planinar2 = new Planinar(ime, prezime, godiste, brojClKarte, istekClanarine, brojTelefona, email);
				planinar2.setIdPlaninar(idPlaninar);
				planinar2.setKlub(klub);
				listPlaninara.add(planinar2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return listPlaninara;
	}

	public void deletePlaninar(Planinar planinar) {
		// TODO Auto-generated method stub
		String sql = "delete from `planinar` where id_planinar = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, planinar.getIdPlaninar());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void editPlaninar(Planinar planinar) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `planinar` SET `ime`=?,`prezime`=?,`godiste`=?,`broj_clanske_karte`=?,`clanarina`=?,`broj_telefona`=?,`email`=?,`id_klub`=? WHERE id_planinar = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, planinar.getIme());
			preparedStatement.setString(2, planinar.getPrezime());
			preparedStatement.setInt(3, planinar.getGodiste());
			preparedStatement.setString(4, planinar.getBrojClanskeKarte());
			preparedStatement.setDate(5, Date.valueOf(planinar.getIstekClanarine()));
			preparedStatement.setString(6, planinar.getBrojTelefona());
			preparedStatement.setString(7, planinar.getEmail());
			preparedStatement.setInt(8, planinar.getKlub().getIdKlub());
			preparedStatement.setInt(9, planinar.getIdPlaninar());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<Vodic> vratiVodiceKluba(Vodic vodic) {
		// TODO Auto-generated method stub
		List<Vodic> listaVodicaZaKlub = new ArrayList<Vodic>();
		String sql ="select id_vodic, ime, prezime, broj_licence from vodic where id_klub = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, vodic.getKlub().getIdKlub());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String ime = resultSet.getString("ime");
				String prezime = resultSet.getString("prezime");
				int idVodic = resultSet.getInt("id_vodic");
				String brojLicence = resultSet.getString("broj_licence");
				Vodic v1 = new Vodic();
				v1.setBrojLicence(brojLicence);
				v1.setIme(ime);
				v1.setPrezime(prezime);
				v1.setIdVodic(idVodic);
				listaVodicaZaKlub.add(v1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaVodicaZaKlub;
	}

	public void SacuvajAkciju(Akcija akcija) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `akcija`(`destinacija`, `datum`, `tip_akcije`, `cena`, `link`, `id_klub`, `id_vodic`) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, akcija.getDestinacija());
			preparedStatement.setDate(2, Date.valueOf(akcija.getDatumAkcije()));
			preparedStatement.setString(3, akcija.getTipAKcije());
			preparedStatement.setDouble(4, akcija.getCena());
			preparedStatement.setString(5, akcija.getLinkAkcije());
			preparedStatement.setInt(6, akcija.getKlub().getIdKlub());
			preparedStatement.setInt(7, akcija.getVodic().getIdVodic());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		String sql =  "INSERT INTO `users`(`username`, `password`, `email`, `ime`, `prezime`, `status`) VALUES (?,?,?,?,?,?)";
		int idUser=0;
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getIme());
			preparedStatement.setString(5, user.getPrezime());
			preparedStatement.setInt(6, 0);
			preparedStatement.execute();
			
			String sqlIdUser = "select id_user from users where username = ? and password = ?";
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlIdUser);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				idUser = resultSet.getInt("id_user");
			}
			
			String sqlRola = "INSERT INTO `user_role`(`id_user`, `id_role`) VALUES (?,?)";
			preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlRola);
			preparedStatement.setInt(1, idUser);
			preparedStatement.setInt(2, 2);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<Akcija> vratiListuAkcija(Akcija akcija) {
		// TODO Auto-generated method stub
		List<Akcija> listaAkcijas = new ArrayList<Akcija>();
		String sql = "select * from akcija INNER JOIN klub on akcija.id_klub = klub.id_klub inner JOIN vodic on akcija.id_vodic = vodic.id_vodic";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idAkcija = resultSet.getInt("id_akcija");
				String destinacija = resultSet.getString("destinacija");
				LocalDate datumAkcije = resultSet.getDate("datum").toLocalDate();
				double cena = resultSet.getDouble("cena");
				String tipAkcije = resultSet.getString("tip_akcije");
				String link = resultSet.getString("link");
				
				String nazivKluba = resultSet.getString("naziv");
				int idKluba = resultSet.getInt("id_klub");
				
				String imeVodica = resultSet.getString("ime");
				String prezimeVodica = resultSet.getString("prezime");
				String brojLicence = resultSet.getString("broj_licence");
				int idVodica = resultSet.getInt("id_vodic");
				
				Klub klub = new Klub();
				klub.setNaziv(nazivKluba);
				klub.setIdKlub(idKluba);
				
				Vodic vodic = new Vodic();
				vodic.setBrojLicence(brojLicence);
				vodic.setIme(imeVodica);
				vodic.setPrezime(prezimeVodica);
				vodic.setIdVodic(idVodica);
				
				Akcija akcija2 = new Akcija(idAkcija, destinacija, datumAkcije, tipAkcije, cena, link, vodic, klub);
				listaAkcijas.add(akcija2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaAkcijas;
	}

	public void deleteAkciju(Akcija akcija) {
		// TODO Auto-generated method stub
		String sql = "delete from akcija where id_akcija = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, akcija.getIdAkcija());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void izmeniAkciju(Akcija akcija) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `akcija` SET `destinacija`=?,`datum`=?,`tip_akcije`=?,`cena`=?,`link`=?,`id_klub`=?,`id_vodic`=? WHERE id_akcija = ?";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, akcija.getDestinacija());
			preparedStatement.setDate(2, Date.valueOf(akcija.getDatumAkcije()));
			preparedStatement.setString(3, akcija.getTipAKcije());
			preparedStatement.setDouble(4, akcija.getCena());
			preparedStatement.setString(5, akcija.getLinkAkcije());
			preparedStatement.setInt(6, akcija.getKlub().getIdKlub());
			preparedStatement.setInt(7, akcija.getVodic().getIdVodic());
			preparedStatement.setInt(8, akcija.getIdAkcija());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void sacuvajRezervaciju(Rezervacija rezervacija) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `rezervacija`(`id_planinar`, `id_akcija`) VALUES (?,?)";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, rezervacija.getPlaninar().getIdPlaninar());
			preparedStatement.setInt(2, rezervacija.getAkcija().getIdAkcija());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Rezervacija> vratiListuRezervacija(Rezervacija rezervacija) {
		// TODO Auto-generated method stub
		List<Rezervacija> listaRezervacija = new ArrayList<Rezervacija>();
		String sql = "select * from rezervacija";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Planinar p = new Planinar();
				int idPlaninar = resultSet.getInt("id_planinar");
				int idAkcija = resultSet.getInt("id_akcija");
				Akcija a = new Akcija();
				p.setIdPlaninar(idPlaninar);
				a.setIdAkcija(idAkcija);
				int idRezervacija = resultSet.getInt("id_rezervacija");
				Rezervacija r = new Rezervacija(idRezervacija, a, p);
				listaRezervacija.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaRezervacija;
	}

	public void upisiAdresu(Adresa adresa) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `adresa`(`mesto`, `postanski_broj`, `ulica`, `broj`, `id_klub`) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, adresa.getMesto());
			preparedStatement.setInt(2, adresa.getPostanski_broj());
			preparedStatement.setString(3, adresa.getUlica());
			preparedStatement.setString(4, adresa.getBroj());
			preparedStatement.setInt(5, adresa.getKlub().getIdKlub());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void upisiKontakt(Kontakt kontakt) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `kontakt`(`broj_telefona`, `email`, `web_sajt`, `id_klub`) VALUES (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, kontakt.getBrojTelefona());
			preparedStatement.setString(2, kontakt.getEmail());
			preparedStatement.setString(3, kontakt.getWebSajt());
			preparedStatement.setInt(4, kontakt.getKlub().getIdKlub());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	
	
}
