package au.gov.ga.ozmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.service.CommodityService;
import au.gov.ga.ozmin.util.Paginator;

/**
 * Created by michael on 9/09/2015.
 */
@Controller
@RequestMapping(value = "/commodities")
public class CommodityController {
	private CommodityService commodityService;

	@Autowired(required = true)
	@Qualifier(value = "commodityService")
	public void setCommodityService(CommodityService cts) {
		this.commodityService = cts;
	}

	// Index
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String commoditiesPage(Model model, Pageable pageable) {

		Paginator<Commodity> commoditiesPage = new Paginator<Commodity>(commodityService.commoditiesPage(pageable),
				"/commodities");

		model.addAttribute("commoditiesPage", commoditiesPage);

		return "commodities/index";
	}

	// Show {id}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showCommodity(@PathVariable("id") String id, Model model) {
		model.addAttribute("commodity", this.commodityService.getCommodityById((id)));
		return "commodities/show";
	}

	// @RequestMapping(value ="/commodities/add", method = RequestMethod.POST)
	// public String addCommodity(@ModelAttribute("commodity") Commodity ct) {
	//
	// if (ct.getId() == null) {
	// this.commodityService.addCommodity(ct);
	// } else {
	// this.commodityService.updateCommodity(ct);
	// }
	// return "redirect:/commodities/";
	// }

	// @RequestMapping("/remove/{id}")
	// public String removeCommodity(@PathVariable("id") String id) {
	// this.commodityService.removeCommodity(id);
	// return "redirect:/commodities/";
	// }
	//
	// @RequestMapping("/edit/{id}")
	// public String editCommodity(@PathVariable("id") String id, Model model) {
	// model.addAttribute("commodity",
	// this.commodityService.getCommodityById((id)));
	// model.addAttribute("listCommoditys");
	// return "commodities/edit";
	// }

}
