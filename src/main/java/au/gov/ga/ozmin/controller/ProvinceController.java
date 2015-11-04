package au.gov.ga.ozmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.gov.ga.ozmin.model.Province;
import au.gov.ga.ozmin.service.ProvinceService;
import au.gov.ga.ozmin.util.Paginator;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
	private ProvinceService provinceService;
	
	@Autowired(required=true)
	@Qualifier(value = "provinceService")
	public void setProvinceService (ProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String provincesPage(Model model, Pageable pageable) {
		Paginator<Province> provincesPage = new Paginator<Province> (provinceService.provincesPage(pageable), "/provinces");
		model.addAttribute("provincesPage", provincesPage);
		return "provinces/index";
		
	}
}
