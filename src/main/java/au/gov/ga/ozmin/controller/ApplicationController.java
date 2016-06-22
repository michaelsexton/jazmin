package au.gov.ga.ozmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class ApplicationController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}
}
