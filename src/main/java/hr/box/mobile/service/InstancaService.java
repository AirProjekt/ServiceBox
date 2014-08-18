package hr.box.mobile.service;

import hr.box.mobile.domain.Instanca;
import java.util.List;

public interface InstancaService {
	
	public Instanca findById(int id);
	
	public Instanca save(Instanca instanca);
	
	public void delete(Instanca instanca);
	
	public List<Instanca> findByObjektId(int id);
	
	public List<Instanca> findByObjektIds(Integer[] ids);
}
