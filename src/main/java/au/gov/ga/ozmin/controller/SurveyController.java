package au.gov.ga.ozmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.gov.ga.ozmin.model.Survey;
import au.gov.ga.ozmin.service.SurveyService;
import au.gov.ga.ozmin.util.Paginator;

@Controller
@RequestMapping(value="/surveys")
public class SurveyController {
	private SurveyService surveyService;
	
	@Autowired(required=true)
	@Qualifier(value="surveyService")
	public void setSurveyService (SurveyService surveyService) {
		this.surveyService=surveyService;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String surveysPage(Model model, Pageable pageable) {
		Paginator<Survey> surveysPage = new Paginator<Survey>(surveyService.surveysPage(pageable), "/surveys");
		model.addAttribute("surveysPage", surveysPage);
		return "surveys/index";
		
	}
	
}
