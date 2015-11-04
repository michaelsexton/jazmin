/**
 * 
 */
package au.gov.ga.ozmin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import au.gov.ga.ozmin.model.Survey;


public interface SurveyRepository extends PagingAndSortingRepository<Survey, Long> {

}
