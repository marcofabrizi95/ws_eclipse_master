package it.prova.service.user;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.AutoreDAO;
import it.prova.dao.CasaDiscograficaDAO;
import it.prova.dao.CdDAO;
import it.prova.dao.Constants;
import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;
import it.prova.model.Cd;

public class CasaDiscograficaServiceImpl implements CasaDiscograficaService {

	private CasaDiscograficaDAO casaDisograficaDao;
	private AutoreDAO autoreDao;
	private CdDAO cdDao;

	public void setCasaDisograficaDao(CasaDiscograficaDAO casaDisograficaDao) {
		this.casaDisograficaDao = casaDisograficaDao;
	}

	public void setAutoreDAO(AutoreDAO autoreDao) {
		this.autoreDao = autoreDao;
	}

	public void setCdDao(CdDAO cdDao) {
		this.cdDao = cdDao;
	}

	@Override
	public void setCasaDIscograficaDAO(CasaDiscograficaDAO casaDiscograficaDAO) {
		this.casaDisograficaDao = casaDiscograficaDAO;

	}

	@Override
	public CasaDiscografica findCasadiscograficaById(Long idInput) throws Exception {
		CasaDiscografica result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int rimuoviCasaDiscografica(CasaDiscografica input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiornaUser(CasaDiscografica input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovoCasaDicografica(CasaDiscografica input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> listAllCasaDiscografica() throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public void aggiungiAutori(CasaDiscografica input) throws Exception {
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			casaDisograficaDao.populateAutore(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void deleteCascade(CasaDiscografica input) throws Exception {
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			casaDisograficaDao.setConnection(connection);
			autoreDao.setConnection(connection);
			cdDao.setConnection(connection);
			casaDisograficaDao.populateAutore(input);
			for (Autore item : input.getAutori()) {
				autoreDao.populateCd(item);
				for (Cd item2 : item.getListaCD())
					cdDao.delete(item2);
				autoreDao.delete(item);
			}
			casaDisograficaDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.findAllByAutoreWhereCognomeIniziaCon(iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDisograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDisograficaDao.findAllByCdWhereGenereEqual(genere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
