package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.CasaDiscografica;

public class CasaDiscograficaDAO {

	public List<CasaDiscografica> list() {

		List<CasaDiscografica> result = new ArrayList<CasaDiscografica>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from casadiscografica;");

			while (rs.next()) {
				CasaDiscografica casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setRagioneSociale(rs.getString("partitaiva"));

				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(CasaDiscografica casaDiscograficaInput) {

		if (casaDiscograficaInput == null)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO casadiscografica (ragionesociale, partitaiva) VALUES (?, ?);");
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int update(CasaDiscografica casaDiscograficaInput) {
		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("UPDATE casadiscografica SET ragionesociale=?, partitaiva=? WHERE id=? ;");
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());
			ps.setLong(3, casaDiscograficaInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int delete(CasaDiscografica casaDiscograficaInput) {
		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("DELETE FROM casadiscografica WHERE id=? ;");
			ps.setLong(1, casaDiscograficaInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}
	public CasaDiscografica selectById(Long id) {

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CasaDiscografica result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from casadiscografica i where i.id=?;");
			ps.setLong(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new CasaDiscografica();
				result.setId(rs.getLong("id"));
				result.setRagioneSociale(rs.getString("ragionesociale"));
				result.setPartitaIva(rs.getString("partitaiva"));
				
			} else {
				result = null;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
