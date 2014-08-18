package hr.box.mobile.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import hr.box.mobile.domain.Kategorija;
import hr.box.mobile.repository.KategorijaRepository;
import hr.box.mobile.service.KategorijaService;

@Service("kategorijaService")
@Repository
@Transactional
public class KategorijaServiceImpl implements KategorijaService{
	
	@Autowired
	private KategorijaRepository kategorijaRepository;

	@Override
	public List<Kategorija> findAll() {
		return Lists.newArrayList(kategorijaRepository.findAll());
	}

	@Override
	public Kategorija findById(Integer id) {
		return kategorijaRepository.findOne(id);
	}

	@Override
	public Kategorija save(Kategorija kategorija) {
		return kategorijaRepository.save(kategorija);
	}

	@Override
	public void delete(Kategorija kategorija) {
		kategorijaRepository.delete(kategorija);
	}

}
