package hr.box.mobile.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import hr.box.mobile.domain.Ocjene;
import hr.box.mobile.repository.OcjeneRepository;
import hr.box.mobile.service.OcjeneService;

@Service("ocjeneService")
@Repository
@Transactional
public class OcjeneServiceImpl implements OcjeneService{
	
	@Autowired
	private OcjeneRepository ocjeneRepository;

	@Override
	public Ocjene save(Ocjene ocjene) {
		return ocjeneRepository.save(ocjene);
	}

	@Override
	public void delete(int id) {
		ocjeneRepository.delete(id);
	}

	@Override
	public Page<Ocjene> findOcjeneByCriteria(String comment, String objektName,
			Pageable pageable) {
		return ocjeneRepository.findOcjeneByCriteria(comment, objektName, pageable);
	}

	@Override
	public Page<Ocjene> findByObjektId(int objektId, Pageable pageable) {
		return ocjeneRepository.findByObjektId(objektId, pageable);
	}

	@Override
	public List<Ocjene> findAll() {
		return Lists.newArrayList(ocjeneRepository.findAll());
	}

}
