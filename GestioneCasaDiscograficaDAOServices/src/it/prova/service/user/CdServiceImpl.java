package it.prova.service.user;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.CdDAO;
import it.prova.dao.Constants;
import it.prova.model.Autore;
import it.prova.model.Cd;

public class CdServiceImpl implements CdService {
	private CdDAO cdDao;

	public Cd findCdById(Long idInput) throws Exception {
		Cd result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public void setCdDAO(CdDAO cdDao) {
		this.cdDao = cdDao;
	}

	@Override
	public int rimuoviCd(Cd input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiornaCd(Cd input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			
			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.update(input);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovoCd(Cd input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> listAllAutore() throws Exception {
		List<Cd> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public List<Cd> findByExample(Cd input) throws Exception {
		List<Cd> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> findAllByGenere(String genere) throws Exception {
		List<Cd> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findAllByGenere(genere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> findAllByAutoreWhereTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception {
		List<Cd> result = new ArrayList<>();
		
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			connection.setAutoCommit(false);
			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findAllByAutoreWhereTitoloIniziaCon(autoreInput, iniziale);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}


}
