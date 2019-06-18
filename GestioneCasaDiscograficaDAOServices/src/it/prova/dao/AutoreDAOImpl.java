package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;
import it.prova.model.Cd;

public class AutoreDAOImpl extends AbstractMySQLDAO implements AutoreDAO {

	@Override
	public Autore get(Long id) throws Exception {
		if (isNotActive()) {
			return null;
		}

		Autore result = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from autore a inner join casadiscografica c on a.casadiscografica=c.id where a.id="+id);
			if (rs.next()) {
				result = new Autore();
				result.setNome(rs.getString("nome"));
				result.setCognome(rs.getString("cognome"));
				result.setId(rs.getLong("ID"));

				CasaDiscografica item = new CasaDiscografica();
				item.setPartitaIva(rs.getString("partitaiva"));
				item.setRagioneSociale(rs.getString("ragionesociale"));
				result.setCasaDiscografica(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int update(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;
		
		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE user SET nome=?, cognome=?, casadiscografica=? where id=?;")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setLong(3, input.getCasaDiscografica().getId());

			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		
		return result;
	}

	@Override
	public int insert(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO user (nome, cognome,casadiscografica) VALUES (?, ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setLong(3, input.getCasaDiscografica().getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM autore WHERE ID=" + input.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Autore> findByExample(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<Autore> result = new ArrayList<Autore>();
		Autore userTemp = null;

		String query = "select * from autore where 1=1 ";
		if (input.getCognome() != null && !input.getCognome().equals("")) {
			query += " and cognome='" + input.getCognome() + "' ";
		}
		if (input.getNome() != null && !input.getNome().equals("")) {
			query += " and nome='" + input.getNome() + "' ";
		}

		if (input.getCasaDiscografica() != null && !(input.getCasaDiscografica().getId() < 1)) {
			query += " and casadiscografica='" + input.getCasaDiscografica().getId() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				userTemp = new Autore();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				input.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Autore> list() throws Exception {

		if (isNotActive()) {
			return null;
		}

		ArrayList<Autore> arr = new ArrayList<Autore>();
		Autore userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery(
					"select * from autore a LEFT outer join casadiscografica c on a.casadiscografica=c.id;");

			while (rs.next()) {
				userTemp = new Autore();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setId(rs.getLong("ID"));

				CasaDiscografica item = new CasaDiscografica();
				item.setPartitaIva(rs.getString("partitaiva"));
				item.setRagioneSociale(rs.getString("ragionesociale"));
				userTemp.setCasaDiscografica(item);
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;

	}

	@Override
	public void populateCd(Autore input) throws Exception {

		if (isNotActive() || input.getId() < 1) {
			return;
		}

		try (PreparedStatement ps = connection
				.prepareStatement("SELECT * FROM cd a INNER JOIN autore n ON a.autore_id=n.id WHERE n.id= ?;")) {
			ps.setLong(1, input.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cd temp = new Cd();
				temp.setId(rs.getLong("id"));
				temp.setNumeroTracce(rs.getInt("numerotracce"));
				temp.setGenere(rs.getString("genere"));
				temp.setTitolo(rs.getString("titolo"));
				temp.setAutore(input);
				input.getListaCD().add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Autore> arr = new ArrayList<Autore>();
		Autore userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery(
					"select * from autore a inner join casadiscografica c on a.casadiscografica=c.id where c.id ="+input.getId());

			while (rs.next()) {
				userTemp = new Autore();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setId(rs.getLong("ID"));

				CasaDiscografica item = new CasaDiscografica();
				item.setPartitaIva(rs.getString("partitaiva"));
				item.setRagioneSociale(rs.getString("ragionesociale"));
				userTemp.setCasaDiscografica(item);
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;

	}

	@Override
	public List<Autore> findBbyCdWhereNTracceGreaterThan(int nTracceInput) throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Autore> arr = new ArrayList<Autore>();
		Autore userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery(
					"select * from autore a inner join cd c on a.id=c.autore_id where c.numerotracce <"+nTracceInput);

			while (rs.next()) {
				userTemp = new Autore();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setId(rs.getLong("ID"));

				CasaDiscografica item = new CasaDiscografica();
				item.setPartitaIva(rs.getString("partitaiva"));
				item.setRagioneSociale(rs.getString("ragionesociale"));
				userTemp.setCasaDiscografica(item);
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;

	}
}
