package au.gov.ga.ozmin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import au.gov.ga.ozmin.model.MineralDeposit;

public interface MineralDepositService {
    Page<MineralDeposit> mineralDepositsPage(Pageable pageable);

       MineralDeposit getDepositById(Long id);

	Page<MineralDeposit> mineralDeposits(Specification<MineralDeposit> specification, Pageable pageable);
}