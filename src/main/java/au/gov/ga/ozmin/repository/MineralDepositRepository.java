package au.gov.ga.ozmin.repository;

import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import au.gov.ga.ozmin.model.MineralDeposit;

public interface MineralDepositRepository
		extends JpaRepository<MineralDeposit, Long>, JpaSpecificationExecutor<MineralDeposit> {
	List<MineralDeposit> findByName(String name);

	List<MineralDeposit> findAll(Specification<MineralDeposit> specification);

}
