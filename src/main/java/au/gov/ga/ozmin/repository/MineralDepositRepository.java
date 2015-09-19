package au.gov.ga.ozmin.repository;


import au.gov.ga.ozmin.model.MineralDeposit;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MineralDepositRepository extends PagingAndSortingRepository<MineralDeposit, Long> {
	List<MineralDeposit> findByName(String name);

}
