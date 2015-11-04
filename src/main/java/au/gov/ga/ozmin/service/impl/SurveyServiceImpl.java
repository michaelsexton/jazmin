package au.gov.ga.ozmin.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import au.gov.ga.ozmin.model.Survey;
import au.gov.ga.ozmin.repository.SurveyRepository;
import au.gov.ga.ozmin.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Inject
	private SurveyRepository surveyRepository;
	
	@Override
	public Page<Survey> surveysPage(Pageable pageable) {

		return this.surveyRepository.findAll(pageable);
	}

}
