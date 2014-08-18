package hr.box.mobile.service;

import hr.box.mobile.domain.Kategorija;

import java.util.List;

public interface KategorijaService {
	
	public List<Kategorija> findAll();
	
	public Kategorija findById(Integer id);
	
	public Kategorija save(Kategorija kategorija);
	
	public void delete(Kategorija kategorija);
	
}
