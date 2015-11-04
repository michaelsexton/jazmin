package au.gov.ga.ozmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.service.MineralDepositService;
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
    public void setMineralDepositService(MineralDepositService ds) { this.mineralDepositService = ds;}

    //Index
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mineralDepositsPage(Model model, Pageable pageable  ) {
        Paginator<MineralDeposit> mineralDepositsPage = new Paginator<MineralDeposit>(mineralDepositService.mineralDepositsPage(pageable),"/mineralDeposits");
        model.addAttribute("mineralDepositsPage", mineralDepositsPage);


        return "deposits/index";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showDeposit(@PathVariable("id") Long id, Model model) {
    	MineralDeposit mineralDeposit =  this.mineralDepositService.getDepositById(id);
    	model.addAttribute("deposit", mineralDeposit);
    	model.addAttribute("mineralisedZones", mineralDeposit.getMineralisedZones());
    	model.addAttribute("orders", mineralDeposit.getOrderedCommodities().values());
    	model.addAttribute("provinces", mineralDeposit.getProvinces());
    return "deposits/show";
}
}
