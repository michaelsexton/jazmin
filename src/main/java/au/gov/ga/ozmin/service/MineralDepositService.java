package au.gov.ga.ozmin.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import au.gov.ga.ozmin.model.MineralDeposit;



/**
 * Created by michael on 10/09/2015.
 */
public interface MineralDepositService {
    Page<MineralDeposit> mineralDepositsPage(Pageable pageable);

       MineralDeposit getDepositById(Long id);

	List<MineralDeposit> mineralDeposits(Specification<MineralDeposit> specification);
}