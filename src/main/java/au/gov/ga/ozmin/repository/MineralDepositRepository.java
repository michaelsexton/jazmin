package au.gov.ga.ozmin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import au.gov.ga.ozmin.model.MineralDeposit;

public interface MineralDepositRepository
		extends PagingAndSortingRepository<MineralDeposit, Long>, JpaSpecificationExecutor<MineralDeposit> {

	Page<MineralDeposit> findAll(Specification<MineralDeposit> specification, Pageable pageable);

}
