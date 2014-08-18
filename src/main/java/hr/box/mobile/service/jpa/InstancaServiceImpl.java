package hr.box.mobile.service.jpa;

import hr.box.mobile.domain.Instanca;
import hr.box.mobile.domain.Objekt;
import hr.box.mobile.repository.InstancaRepository;
import hr.box.mobile.repository.ObjektRepository;
import hr.box.mobile.service.InstancaService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("instancaService")
@Repository
@Transactional
public class InstancaServiceImpl implements InstancaService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private InstancaRepository instancaRepository;
	
	@Autowired
	private ObjektRepository objektRepository;

	@Override
	public Instanca findById(int id) {
		return instancaRepository.findOne(id);
	}

	@Override
	public Instanca save(Instanca instanca) {
		return instancaRepository.save(instanca);
	}

	@Override
	public void delete(Instanca instanca) {
		instancaRepository.delete(instanca);
	}

	@Override
	public List<Instanca> findByObjektId(int id) {
		Objekt objekt = objektRepository.findOne(id);
		List<Instanca> lista = new ArrayList<Instanca>(objekt.getInstance());
		return lista;
	}

	@Override
	public List<Instanca> findByObjektIds(Integer[] ids) {
		
		TypedQuery<Instanca> q = 
				em.createQuery("select i from Instanca i left join i.objekt o where o.id in (:id)", Instanca.class);
		q.setParameter("id", Arrays.asList(ids));
		return q.getResultList();
		
	}
	
	
}
