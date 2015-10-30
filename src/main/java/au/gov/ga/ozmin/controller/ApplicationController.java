package au.gov.ga.ozmin.controller;

//import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import au.gov.ga.ozmin.model.SpatialEntity;
// TODO: Make Front page for Spatial Entity
@Controller
@RequestMapping(value = "/")
public class ApplicationController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listEntities(Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer pageNumber) {
		return "index";
		// Page<Commodity> commodityPage =
		// commodityService.listCommodities(pageNumber);
		//
		// int current = commodityPage.getNumber() + 1;
		// int begin = Math.max(1, current - 5);
		// int end = Math.min(begin + 10, commodityPage.getTotalPages());
		//
		// model.addAttribute("listCommodities", commodityPage);
		// model.addAttribute("beginIndex", begin);
		// model.addAttribute("endIndex", end);
		// model.addAttribute("currentIndex", current);
		//
		// //model.addAttribute("listCommodities",
		// this.commodityService.listCommodities());
		//
		//
		// return "commodities/index";
	}
}
