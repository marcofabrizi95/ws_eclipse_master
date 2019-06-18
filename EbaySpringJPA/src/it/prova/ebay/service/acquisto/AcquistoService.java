package it.prova.ebay.service.acquisto;

import java.util.List;

import it.prova.ebay.model.Acquisto;

public interface AcquistoService {
	public List<Acquisto> list();
	public Acquisto get(long id);
	public void update(Acquisto o);
	public void insert(Acquisto o);
	public void delete(Acquisto o);
	public List<Acquisto> findByExample(Acquisto o);
	public boolean eseguiAcquisto(long annuncioId,long userId);
	
	
	
}
