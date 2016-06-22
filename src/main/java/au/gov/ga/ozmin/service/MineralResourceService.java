package au.gov.ga.ozmin.service;

import java.util.Date;
import java.util.Set;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.model.MineralResource;

public interface MineralResourceService {
	Page<MineralResource> listMineralResources(Pageable pageable);
	
	Set<MineralDeposit> mineralResourcesCollectionForQualityCheck(String qaStatus, String enteredBy);

	Page<MineralResource> listMineralResourcesForAdministration(Pageable pageable, String enteredBy, Date startDate,
			Date endDate);

	Page<MineralResource> mineralResources(Specification<MineralResource> specification, Pageable pageable);

	MineralResource getMineralResourceById(Long id);
	
}
