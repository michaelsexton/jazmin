package au.gov.ga.ozmin.service;

import au.gov.ga.ozmin.model.MineralDeposit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/**
 * Created by michael on 10/09/2015.
 */
public interface MineralDepositService {
    Page<MineralDeposit> mineralDepositsPage(Pageable pageable);
//    void addDeposit(MineralDeposit deposit);
//    void updateDeposit(MineralDeposit deposit);
//    List<MineralDeposit> listDeposits();
       MineralDeposit getDepositById(Long id);
//    void removeDeposit(int id);
	List<MineralDeposit> mineralDeposits();
}
