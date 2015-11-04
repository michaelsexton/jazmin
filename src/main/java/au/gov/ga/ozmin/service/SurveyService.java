package au.gov.ga.ozmin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import au.gov.ga.ozmin.model.Survey;

public interface SurveyService {
	Page<Survey> surveysPage(Pageable pageable);
}
