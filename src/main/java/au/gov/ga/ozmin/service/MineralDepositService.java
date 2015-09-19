package au.gov.ga.ozmin.service;

import au.gov.ga.ozmin.model.MineralDeposit;
import org.springframework.data.domain.Page;



/**
 * Created by michael on 10/09/2015.
 */
public interface MineralDepositService {
    Page<MineralDeposit> listMineralDeposits(Integer pageNumber);
//    void addDeposit(MineralDeposit deposit);
//    void updateDeposit(MineralDeposit deposit);
//    List<MineralDeposit> listDeposits();
       MineralDeposit getDepositById(Long id);
//    void removeDeposit(int id);
}
