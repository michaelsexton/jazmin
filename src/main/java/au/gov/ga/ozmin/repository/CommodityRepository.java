package au.gov.ga.ozmin.repository;

import java.util.List;


import au.gov.ga.ozmin.model.Commodity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommodityRepository extends PagingAndSortingRepository<Commodity, String> {
	List<Commodity> findByName(String name);
}
