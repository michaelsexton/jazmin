package au.gov.ga.ozmin.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import au.gov.ga.ozmin.model.MineralDeposit;

public interface MineralDepositRepository extends PagingAndSortingRepository<MineralDeposit, Long> {
	List<MineralDeposit> findByName(String name);
	
	List<MineralDeposit> findAll();

	
}
