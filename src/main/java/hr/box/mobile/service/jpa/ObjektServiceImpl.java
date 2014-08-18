package hr.box.mobile.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import hr.box.mobile.domain.Kategorija;
import hr.box.mobile.domain.Objekt;
import hr.box.mobile.repository.KategorijaRepository;
import hr.box.mobile.repository.ObjektRepository;
import hr.box.mobile.service.ObjektService;

@Service("objektService")
@Repository
@Transactional
public class ObjektServiceImpl implements ObjektService{
	
	@Autowired
	ObjektRepository objektRepository;
	
	@Autowired
	KategorijaRepository kategorijaRepository;

	@Override
	public List<Objekt> findAll() {
		return Lists.newArrayList(objektRepository.findAll());
	}

	@Override
	public Objekt findById(int id) {
		return objektRepository.findOne(id);
	}

	@Override
	public Objekt save(Objekt objekt) {
		return objektRepository.save(objekt);
	}

	@Override
	public void delete(Objekt objekt) {
		objektRepository.delete(objekt);
		
	}

	@Override
	public List<Objekt> findByKategorijaId(int id) {
		Kategorija kategorija = kategorijaRepository.findOne(id);
		List<Objekt> lista = new ArrayList<Objekt>(kategorija.getObjekti());
		return lista;
	}

}
