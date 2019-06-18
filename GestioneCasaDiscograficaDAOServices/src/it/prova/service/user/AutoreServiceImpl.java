package it.prova.service.user;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.AutoreDAO;
import it.prova.dao.CdDAO;
import it.prova.dao.Constants;
import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;
import it.prova.model.Cd;

public class AutoreServiceImpl implements AutoreService {
	private AutoreDAO autoreDao;
	private CdDAO cdDao;

	public void setCdDao(CdDAO cdDao) {
		this.cdDao = cdDao;
	}

	@Override
	public Autore findAutoreById(Long idInput) throws Exception {
		Autore result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public void setAutoreDAO(AutoreDAO autoreDao) {
		this.autoreDao = autoreDao;

	}

	@Override
	public int rimuoviAutore(Autore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiornaAutore(Autore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovoAutore(Autore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Autore> listAllAutore() throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	public List<Autore> findByExample(Autore input) throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public void setAutoreDao(AutoreDAO autoreDao) {
		this.autoreDao = autoreDao;
	}

	@Override
	public void aggiungiCd(Autore input) throws Exception {
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			autoreDao.populateCd(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void deleteCascade(Autore input) throws Exception {
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			autoreDao.setConnection(connection);
			cdDao.setConnection(connection);
			autoreDao.populateCd(input);
			for (Cd item : input.getListaCD())
				cdDao.delete(item);

			autoreDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findAllByCasaDiscografica(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public List<Autore> findBbyCdWhereNTracceGreaterThan(int nTracceInput) throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findBbyCdWhereNTracceGreaterThan(nTracceInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

}
