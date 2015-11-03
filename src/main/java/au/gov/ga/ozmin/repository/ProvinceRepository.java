package au.gov.ga.ozmin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import au.gov.ga.ozmin.model.Province;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, String> {

}
