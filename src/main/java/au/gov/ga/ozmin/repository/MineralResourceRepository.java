package au.gov.ga.ozmin.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.model.MineralResource;

public interface MineralResourceRepository extends PagingAndSortingRepository<MineralResource, Long> {

	@Override
	@Query("select mr from MineralResource as mr "
			+ "left join fetch mr.resourceGrades as rg "
			+ "where mr.id = ?1")
	MineralResource findOne(Long id);
	
	Page<MineralResource> findByQaStatus(Pageable pageable, String qaStatus);

	Page<MineralResource> findByQaStatusAndEntryDateBetween(Pageable pageable, String qaStatus, Date lowerDate,
			Date upperDate);

	Page<MineralResource> findByQaStatusAndEnteredByAndEntryDateBetween(Pageable pageable, String qaStatus,
			String enteredBy, Date lowerDate, Date upperDate);

	Set<MineralResource> findByQaStatusAndEnteredBy(String qaStatus,
			String enteredBy);
	
	//List<MineralResource> findAll();
	
	@Query("select mr from MineralResource as mr "
			+ "left join fetch mr.resourceGrades as rg "
			+ "inner join fetch mr.mineralisedZone as mz "
			+ "inner join fetch mz.mineralDeposit as md "
			+ "where mr.qaStatus = ?1 and "
			+ "mr.enteredBy = ?2")
	Set<MineralResource> findResourcesForQA(String qaStatus,
			String enteredBy);
	
	@Query("select md from MineralDeposit as md "
			+ "left join fetch md.mineralisedZones as mz "
			+ "left join fetch mz.mineralResources as mr "
			+ "left join fetch mr.resourceGrades as rg "
			+ "where mr.qaStatus = ?1 and "
			+ "mr.enteredBy = ?2")
	Set<MineralDeposit> findResourcesCollectionForQaByDeposit(String qaStatus,
			String enteredBy) ;
}
