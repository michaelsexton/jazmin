package au.gov.ga.ozmin.service.impl;



import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.repository.MineralDepositRepository;
import au.gov.ga.ozmin.service.MineralDepositService;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;


/**
 * Created by michael on 10/09/2015.
 */
@Service
public class MineralDepositServiceImpl implements MineralDepositService {

    private static final int PAGE_SIZE = 20;

    @Inject
    private MineralDepositRepository mineralDepositRepository;



    public Page<MineralDeposit> listMineralDeposits(Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
        return this.mineralDepositRepository.findAll(pageRequest);

    }

    @Override
    @Transactional
    public MineralDeposit getDepositById(Long id) {
    	MineralDeposit mineralDeposit = this.mineralDepositRepository.findOne(id);
    	Hibernate.initialize(mineralDeposit.getMineralisedZones());
    	Hibernate.initialize(mineralDeposit.getProvinces());
    	Hibernate.initialize(mineralDeposit.getCommodities());
        return mineralDeposit;
    }
    
    

//    @Override
//    @Transactional
//    public void removeDeposit(int id) {
//        this.depositDAO.removeDeposit(id);
//    }
//
//    @Override
//    @Transactional
//    public void addDeposit(MineralDeposit deposit) {
//        this.depositDAO.addDeposit(deposit);
//    }
//
//    @Override
//    @Transactional
//    public void updateDeposit(MineralDeposit deposit) {
//        this.depositDAO.updateDeposit(deposit);
//    }
//
//    @Override
//    @Transactional
//    public List<MineralDeposit> listDeposits() {
//        return this.depositDAO.listDeposits();
//    }
//
//    @Override
//    @Transactional
//    public MineralDeposit getDepositById(int id) {
//        return this.depositDAO.getDepositById(id);
//    }
}
