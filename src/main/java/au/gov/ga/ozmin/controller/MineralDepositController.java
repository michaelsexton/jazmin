package au.gov.ga.ozmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.service.MineralDepositService;
import au.gov.ga.ozmin.specification.MineralDepositSpecification;
import au.gov.ga.ozmin.util.Paginator;

/**
 * Created by michael on 10/09/2015.
 */
@Controller
@RequestMapping("/mineralDeposits")
public class MineralDepositController {
	private MineralDepositService mineralDepositService;

	@Autowired(required = true)
	@Qualifier(value = "mineralDepositService")
	public void setMineralDepositService(MineralDepositService ds) {
		this.mineralDepositService = ds;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MineralDeposit> mineralDeposits(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = false, value = "operatingStatus") String operatingStatus,
			@RequestParam(required = false, value = "state") String state) {
		name = (name != null) ? "%" + name + "%" : null;
		return this.mineralDepositService
				.mineralDeposits(MineralDepositSpecification.searchByParameters(name, operatingStatus, state));
	}

	// Index
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String mineralDepositsPage(Model model, Pageable pageable) {
		Paginator<MineralDeposit> mineralDepositsPage = new Paginator<MineralDeposit>(
				mineralDepositService.mineralDepositsPage(pageable), "/mineralDeposits");
		model.addAttribute("mineralDepositsPage", mineralDepositsPage);

		return "mineralDeposits/index";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public MineralDeposit deposit(@PathVariable("id") Long id) {
		MineralDeposit mineralDeposit = this.mineralDepositService.getDepositById(id);
		return mineralDeposit;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showDeposit(@PathVariable("id") Long id, Model model) {
		MineralDeposit mineralDeposit = this.mineralDepositService.getDepositById(id);
		model.addAttribute("deposit", mineralDeposit);
		model.addAttribute("mineralisedZones", mineralDeposit.getMineralisedZones());
		// model.addAttribute("orders",
		// mineralDeposit.getOrderedCommodities().values());
		model.addAttribute("provinces", mineralDeposit.getProvinces());
		return "mineralDeposits/show";
	}
}
