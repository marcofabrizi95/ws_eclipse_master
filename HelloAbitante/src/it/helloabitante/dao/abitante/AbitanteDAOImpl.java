package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl  implements AbitanteDAO {
	
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();
		
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if(abitanteItem.getNome().equals(nome) && abitanteItem.getCognome().equals(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		
		Abitante userTemp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from abitante where idabitante=" + id);

			if (rs.next()) {
				userTemp = new Abitante();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setCodiceFiscale(rs.getString("codicefiscale"));
				userTemp.setMottoDiVita(rs.getString("mottodivita"));
				userTemp.setEta(rs.getInt("eta"));
				userTemp.setIdAbitante(rs.getLong("idAbitante"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return userTemp;
	}
	@Override
	public int insert(Abitante utenteInput) throws Exception {

		

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO abitante (nome, cognome, codicefiscale, mottodivita, eta) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, utenteInput.getNome());
			ps.setString(2, utenteInput.getCognome());
			ps.setString(3, utenteInput.getCodiceFiscale());
			ps.setString(4, utenteInput.getMottoDiVita());
			ps.setInt(5, utenteInput.getEta());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}
	@Override
	public List<Abitante> list() throws Exception {

		
		ArrayList<Abitante> arr = new ArrayList<Abitante>();
		Abitante userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from abitante");

			while (rs.next()) {
				userTemp = new Abitante();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setCodiceFiscale(rs.getString("codicefiscale"));
				userTemp.setMottoDiVita(rs.getString("mottodivita"));
				userTemp.setEta(rs.getInt("eta"));
				userTemp.setIdAbitante(rs.getLong("idabitante"));
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public int update(Abitante utenteInput) throws Exception {
		

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE abitante SET nome=?, cognome=?, codicefiscale=?, mottodivita=?, eta=? where idabitante=?;")) {
			ps.setString(1, utenteInput.getNome());
			ps.setString(2, utenteInput.getCognome());
			ps.setString(3, utenteInput.getCodiceFiscale());
			ps.setString(4, utenteInput.getMottoDiVita());
			ps.setInt(5, utenteInput.getEta());
			ps.setLong(6, utenteInput.getIdAbitante());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}
	@Override
	public List<Abitante> findByExample(Abitante input) throws Exception {

		
		ArrayList<Abitante> result = new ArrayList<Abitante>();
		Abitante userTemp = null;

		String query = "select * from abitante where 1=1 ";
		if (input.getCognome() != null && !input.getCognome().equals("")) {
			query += " and cognome='" + input.getCognome() + "' ";
		}
		if (input.getNome() != null && !input.getNome().equals("")) {
			query += " and nome='" + input.getNome() + "' ";
		}

		if (input.getCodiceFiscale() != null && !input.getCodiceFiscale().equals("")) {
			query += " and codicefiscale='" + input.getCodiceFiscale() + "' ";
		}

		if (input.getMottoDiVita() != null && !input.getMottoDiVita().equals("")) {
			query += " and mottodivita='" +input.getMottoDiVita() + "' ";
		}


		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				userTemp = new Abitante();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setCodiceFiscale(rs.getString("codicefiscale"));
				userTemp.setMottoDiVita(rs.getString("mottodivita"));
				userTemp.setEta(rs.getInt("eta"));
				userTemp.setIdAbitante(rs.getLong("idabitante"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Abitante utenteInput) throws Exception {
		
		

			int result = 0;

			try (PreparedStatement ps = connection.prepareStatement("DELETE FROM abitante WHERE IDabitante=" + utenteInput.getIdAbitante())) {
				result = ps.executeUpdate();

			} catch (Exception e) {

				e.printStackTrace();
				throw e;
			}
			return result;
		}

}
