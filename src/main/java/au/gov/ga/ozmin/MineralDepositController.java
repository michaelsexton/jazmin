package au.gov.ga.ozmin;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.service.MineralDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by michael on 10/09/2015.
 */
@Controller
@RequestMapping("/deposits")
public class MineralDepositController {
    private MineralDepositService mineralDepositService;

    @Autowired(required = true)
    @Qualifier(value = "mineralDepositService")
    public void setMineralDepositService(MineralDepositService ds) { this.mineralDepositService = ds;}

    //Index
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listDeposits(Model model, @RequestParam("page") Optional<Integer> pageNumber ) {
        int page;
        if (pageNumber.isPresent()) {
            page = pageNumber.get();
        } else {
            page=1;
        }
        Page<MineralDeposit> depositPage = mineralDepositService.listMineralDeposits(page);

        int current = depositPage.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, depositPage.getTotalPages());

        model.addAttribute("listDeposits", depositPage);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);




        return "deposits/index";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showDeposit(@PathVariable("id") Long id, Model model) {
    model.addAttribute("deposit", this.mineralDepositService.getDepositById((id)));
    return "deposits/show";
}
}
