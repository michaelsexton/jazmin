package au.gov.ga.ozmin.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import au.gov.ga.ozmin.model.MineralResource;

public interface MineralResourceService {
	Page<MineralResource> listMineralResources(Pageable pageable);

	Page<MineralResource> listMineralResourcesForAdministration(Pageable pageable, String enteredBy, Date startDate,
			Date endDate);

	MineralResource getMineralResourceById(Long id);
}
