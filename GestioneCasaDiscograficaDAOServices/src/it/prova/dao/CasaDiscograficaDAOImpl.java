package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;

public class CasaDiscograficaDAOImpl extends AbstractMySQLDAO implements CasaDiscograficaDAO {

	@Override
	public CasaDiscografica get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		CasaDiscografica result = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from casadiscografica where id=" + id);

			if (rs.next()) {
				result = new CasaDiscografica();
				result.setRagioneSociale(rs.getString("ragionesociale"));
				result.setPartitaIva(rs.getString("partitaiva"));
				result.setId(rs.getLong("ID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int update(CasaDiscografica utenteInput) throws Exception {
		if (isNotActive() || utenteInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE casadiscografica SET ragionesociale=?, paritaiva=?, id=? where id=?;")) {
			ps.setString(1, utenteInput.getRagioneSociale());
			ps.setString(2, utenteInput.getPartitaIva());
			ps.setLong(3, utenteInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	public int insert(CasaDiscografica utenteInput) throws Exception {

		if (isNotActive() || utenteInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO casadiscografica (ragionesociale, partitaiva) VALUES (?, ?);")) {
			ps.setString(1, utenteInput.getRagioneSociale());
			ps.setString(2, utenteInput.getPartitaIva());

			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(CasaDiscografica utenteInput) throws Exception {

		if (isNotActive() || utenteInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("DELETE FROM casadiscografica WHERE ID=" + utenteInput.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public List<CasaDiscografica> list() throws Exception {

		if (isNotActive()) {
			return null;
		}

		ArrayList<CasaDiscografica> arr = new ArrayList<CasaDiscografica>();
		CasaDiscografica userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from casadiscografica");

			while (rs.next()) {
				userTemp = new CasaDiscografica();
				userTemp.setRagioneSociale(rs.getString("ragionesociale"));
				userTemp.setPartitaIva(rs.getString("paritaiva"));
				userTemp.setId(rs.getLong("ID"));
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception {

		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica userTemp = null;

		String query = "select * from casadiscografica where 1=1 ";
		if (input.getPartitaIva() != null && !input.getPartitaIva().equals("")) {
			query += " and cognome='" + input.getPartitaIva() + "' ";
		}
		if (input.getRagioneSociale() != null && !input.getRagioneSociale().equals("")) {
			query += " and nome='" + input.getRagioneSociale() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				userTemp = new CasaDiscografica();
				userTemp.setRagioneSociale(rs.getString("ragionesociale"));
				userTemp.setPartitaIva(rs.getString("paritaiva"));
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public void populateAutore(CasaDiscografica input) throws Exception {
		if (isNotActive() || input == null)
			return;
		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM autore a INNER JOIN casadiscografica n ON a.casadiscografica=n.id WHERE n.id= ?;")) {
			ps.setLong(1, input.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Autore temp = new Autore();
				temp.setNome(rs.getString("nome"));
				temp.setCognome(rs.getString("cognome"));
				temp.setId(rs.getLong("id"));
				temp.setCasaDiscografica(input);
				input.getAutori().add(temp);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception {
		if(isNotActive() ||iniziale.equals("") )
			return null;
		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();		
				try(Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery("select * from casadiscografica a inner join autore c on c.casadiscografica=a.id where nome like"+iniziale+"%");
			while(rs.next()) {
				
				CasaDiscografica temp = new CasaDiscografica();
				temp.setId(rs.getLong("id"));
				temp.setPartitaIva(rs.getString("partitaiva"));
				temp.setRagioneSociale(rs.getString("ragionesociale"));
				result.add(temp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}

	@Override
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception {
		if(isNotActive() ||genere.equals("") )
			return null;
		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();		
				try(Statement ps = connection.createStatement()){
			ResultSet rs = ps.executeQuery("select * from casadiscografica a inner join autore c on c.casadiscografica=a.id inner join cd i on c.id=i.id where i.genere="+genere+"group by ragionesociale");
			while(rs.next()) {
				
				CasaDiscografica temp = new CasaDiscografica();
				temp.setId(rs.getLong("id"));
				temp.setPartitaIva(rs.getString("partitaiva"));
				temp.setRagioneSociale(rs.getString("ragionesociale"));
				result.add(temp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}

	

}
