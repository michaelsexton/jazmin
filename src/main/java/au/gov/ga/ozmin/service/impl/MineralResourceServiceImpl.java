package au.gov.ga.ozmin.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.repository.MineralResourceRepository;
import au.gov.ga.ozmin.service.MineralResourceService;

@Service
public class MineralResourceServiceImpl implements MineralResourceService {

	@Inject
	private MineralResourceRepository mineralResourceRepository;

	@Override
	public Page<MineralResource> listMineralResources(Pageable pageRequest) {
		// PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE,
		// Sort.Direction.ASC, "recordDate");
		return this.mineralResourceRepository.findAll(pageRequest);

	}

	@Override
	public MineralResource getMineralResourceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MineralResource> listMineralResourcesForAdministration(Pageable pageable, String enteredBy,
			Date startDate, Date endDate) {

		if (enteredBy == null) {
			return this.mineralResourceRepository.findByQaStatusAndEntryDateBetween(pageable, "U", startDate, endDate);
		} else {
			return this.mineralResourceRepository.findByQaStatusAndEnteredByAndEntryDateBetween(pageable, "U",
					enteredBy, startDate, endDate);
		}
	}
}