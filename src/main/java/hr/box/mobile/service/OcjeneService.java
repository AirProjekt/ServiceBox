package hr.box.mobile.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hr.box.mobile.domain.Ocjene;

public interface OcjeneService {
	
	public Ocjene save(Ocjene ocjene);
	
	public void delete(int id);
	
	public Page<Ocjene> findOcjeneByCriteria(String comment, String objektName, Pageable pageable);
	
	public Page<Ocjene> findByObjektId(int objektId, Pageable pageable);
	
	public List<Ocjene> findAll();

}
