package au.gov.ga.ozmin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import au.gov.ga.ozmin.model.Province;

public interface ProvinceService {
	Page<Province> provincesPage(Pageable pageable);
}
