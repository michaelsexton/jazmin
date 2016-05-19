package au.gov.ga.ozmin.repository;


import au.gov.ga.ozmin.model.MineralDeposit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MineralDepositRepository extends PagingAndSortingRepository<MineralDeposit, Long> {
	List<MineralDeposit> findByName(String name);
	
	List<MineralDeposit> findAll();

	/*@Query("select md from MineralDeposit as md "
			+ "left join fetch md.mineralProject "
			+ "left join fetch md.mineralisedZones as mz "
			+ "left join fetch mz.mineralResources as mr "
			+ "left join fetch md.mineralDepositCommodityOrders "
			+ "left join fetch md.provinces "
			+ "where md.id = ?1")
	MineralDeposit findDepositWithAssociatedData(Long id);*/
}
