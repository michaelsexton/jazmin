package au.gov.ga.ozmin.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import au.gov.ga.ozmin.model.Province;
import au.gov.ga.ozmin.repository.ProvinceRepository;
import au.gov.ga.ozmin.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {

	@Inject
	private ProvinceRepository provinceRepository;
	
	@Override
	public Page<Province> provincesPage(Pageable pageable) {
		return this.provinceRepository.findAll(pageable);
	}

}
