package au.gov.ga.ozmin.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.repository.CommodityRepository;
import au.gov.ga.ozmin.service.CommodityService;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {

	@Inject
	private CommodityRepository commodityRepository;

	@Override
	@Transactional
	public Page<Commodity> commoditiesPage(Pageable pageable) {

		return this.commodityRepository.findAll(pageable);

	}

	@Override
	@Transactional
	public Commodity getCommodityById(String id) {
		return this.commodityRepository.findOne(id);
	}

}
