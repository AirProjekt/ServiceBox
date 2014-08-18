package hr.box.mobile.repository;

import hr.box.mobile.domain.Ocjene;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface OcjeneRepository extends PagingAndSortingRepository<Ocjene, Integer>{
	
	@Query("Select o from Ocjene o where o.comment like :comment and o.objekt.name like :objektName")
	public Page<Ocjene> findOcjeneByCriteria(@Param("comment") String comment, 
											 @Param("objektName") String objektName,
											 Pageable pageable);
	
	@Query("Select o from Ocjene o where o.objekt.id = :objektId")
	public Page<Ocjene> findByObjektId(@Param("objektId") int objektId, Pageable pageable);
	
}
