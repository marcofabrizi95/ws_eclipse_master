package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Autore;
import it.prova.model.Cd;

public class CdDAOImpl extends AbstractMySQLDAO implements CdDAO {

	@Override
	public List<Cd> findByExample(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();
		Cd userTemp = null;

		String query = "select * from autore where 1=1 ";
		if (input.getTitolo() != null && !input.getTitolo().equals("")) {
			query += " and titolo='" + input.getTitolo() + "' ";
		}
		if (input.getGenere() != null && !input.getGenere().equals("")) {
			query += " and nome='" + input.getGenere() + "' ";
		}

		if (input.getAutore() != null && !(input.getAutore().getId() < 1)) {
			query += " and casadiscografica='" + input.getAutore().getId() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				userTemp = new Cd();
				userTemp.setTitolo(rs.getString("titolo"));
				userTemp.setGenere(rs.getString("genere"));
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
	public Cd get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		Cd result = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from cd c inner join autore a on a.id=c.autore_id where c.id="+id);
			if (rs.next()) {
				result = new Cd();
				result.setGenere(rs.getString("genere"));
				result.setTitolo(rs.getString("titolo"));
				result.setId(rs.getLong("ID"));
				Autore item = new Autore();
				item.setNome(rs.getString("nome"));
				item.setCognome(rs.getString("cognome"));
				item.setId(rs.getLong("autore_id"));
				result.setAutore(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int update(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("UPDATE cd SET genere=?, titolo=?, autore_id=?,numerotracce=? where id=?;")) {
			ps.setString(1, input.getGenere());
			ps.setString(2, input.getTitolo());
			ps.setLong(3, input.getAutore().getId());
			ps.setInt(4, input.getNumeroTracce());
			ps.setLong(5, input.getId());

			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int insert(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO cd (titolo, genere,autore_id) VALUES (?, ?, ?);")) {
			ps.setString(1, input.getTitolo());
			ps.setString(2, input.getGenere());
			ps.setLong(3, input.getAutore().getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM cd WHERE ID=" + input.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> list() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Cd> arr = new ArrayList<Cd>();
		Cd userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from cd a LEFT outer join autore c on a.autore_id=c.id;");

			while (rs.next()) {
				userTemp = new Cd();
				userTemp.setTitolo(rs.getString("titolo"));
				userTemp.setGenere(rs.getString("genere"));
				userTemp.setId(rs.getLong("ID"));

				Autore item = new Autore();
				item.setNome(rs.getString("partitaiva"));
				item.setCognome(rs.getString("ragionesociale"));
				userTemp.setAutore(item);
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
	public List<Cd> findAllByGenere(String genere) throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Cd> arr = new ArrayList<Cd>();
		Cd userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from cd where genere="+genere);

			while (rs.next()) {
				userTemp = new Cd();
				userTemp.setTitolo(rs.getString("titolo"));
				userTemp.setGenere(rs.getString("genere"));
				userTemp.setId(rs.getLong("ID"));

				Autore item = new Autore();
				item.setNome(rs.getString("partitaiva"));
				item.setCognome(rs.getString("ragionesociale"));
				userTemp.setAutore(item);
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;

	}

	@Override
	public List<Cd> findAllByAutoreWhereTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Cd> arr = new ArrayList<Cd>();
		Cd userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from cd c inner join autore a on c.id=a.id where a.id="+autoreInput.getId()+"and c.titolo like"+iniziale+"%");

			while (rs.next()) {
				userTemp = new Cd();
				userTemp.setTitolo(rs.getString("titolo"));
				userTemp.setGenere(rs.getString("genere"));
				userTemp.setId(rs.getLong("ID"));

				Autore item = new Autore();
				item.setNome(rs.getString("partitaiva"));
				item.setCognome(rs.getString("ragionesociale"));
				userTemp.setAutore(item);
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;

	}



}
