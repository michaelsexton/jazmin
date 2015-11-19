package au.gov.ga.ozmin.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import au.gov.ga.ozmin.model.MineralResource;

public interface MineralResourceRepository extends PagingAndSortingRepository<MineralResource, Long> {

	Page<MineralResource> findByQaStatus(Pageable pageable, String qaStatus);

	Page<MineralResource> findByQaStatusAndEntryDateBetween(Pageable pageable, String qaStatus, Date lowerDate,
			Date upperDate);

	Page<MineralResource> findByQaStatusAndEnteredByAndEntryDateBetween(Pageable pageable, String qaStatus,
			String enteredBy, Date lowerDate, Date upperDate);

	Set<MineralResource> findByQaStatusAndEnteredBy(String qaStatus,
			String enteredBy);
	
	//List<MineralResource> findAll();
}
