package hr.box.mobile.service;

import hr.box.mobile.domain.Objekt;

import java.util.List;

public interface ObjektService {
	
	public List<Objekt> findAll();
	
	public Objekt findById(int id);
	
	public Objekt save(Objekt objekt);
	
	public void delete(Objekt objekt);
	
	public List<Objekt> findByKategorijaId(int id);
}
