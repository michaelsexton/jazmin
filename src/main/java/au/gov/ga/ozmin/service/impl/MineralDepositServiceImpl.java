package au.gov.ga.ozmin.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.repository.MineralDepositRepository;
import au.gov.ga.ozmin.service.MineralDepositService;

/**
 * Created by michael on 10/09/2015.
 */
@Service
public class MineralDepositServiceImpl implements MineralDepositService {


	@Inject
	private MineralDepositRepository mineralDepositRepository;

	public Page<MineralDeposit> mineralDepositsPage(Pageable pageable) {
		return this.mineralDepositRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public MineralDeposit getDepositById(Long id) {
		MineralDeposit mineralDeposit = this.mineralDepositRepository.findDepositWithAssociatedData(id);
		/*Hibernate.initialize(mineralDeposit.getMineralisedZones());
		 Hibernate.initialize(mineralDeposit.getProvinces()); 
		Hibernate.initialize(mineralDeposit.getOrderedCommodities());*/
		return mineralDeposit;
	}

	// @Override
	// @Transactional
	// public void removeDeposit(int id) {
	// this.depositDAO.removeDeposit(id);
	// }
	//
	// @Override
	// @Transactional
	// public void addDeposit(MineralDeposit deposit) {
	// this.depositDAO.addDeposit(deposit);
	// }
	//
	// @Override
	// @Transactional
	// public void updateDeposit(MineralDeposit deposit) {
	// this.depositDAO.updateDeposit(deposit);
	// }
	//
	// @Override
	// @Transactional
	// public List<MineralDeposit> listDeposits() {
	// return this.depositDAO.listDeposits();
	// }
	//
	// @Override
	// @Transactional
	// public MineralDeposit getDepositById(int id) {
	// return this.depositDAO.getDepositById(id);
	// }
}
