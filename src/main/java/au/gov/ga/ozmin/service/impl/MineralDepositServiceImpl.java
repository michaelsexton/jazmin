package au.gov.ga.ozmin.service.impl;

import java.util.List;

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
		return (MineralDeposit) this.mineralDepositRepository.findOne(id);
	}

	@Override
	public List<MineralDeposit> mineralDeposits() {
		return this.mineralDepositRepository.findAll();
	}

}
