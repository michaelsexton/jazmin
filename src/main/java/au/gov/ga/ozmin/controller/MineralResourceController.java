package au.gov.ga.ozmin.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.service.MineralResourceService;
import au.gov.ga.ozmin.util.Paginator;

@Controller
@RequestMapping("/resources")
public class MineralResourceController {
	private MineralResourceService mineralResourceService;

	@Autowired(required = true)
	@Qualifier(value = "mineralResourceService")
	public void setMineralResourceService(MineralResourceService mrs) {
		this.mineralResourceService = mrs;
	}

	// Index
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listResources(Model model, Pageable pageable) {
		Paginator<MineralResource> resourcesPage = new Paginator<MineralResource>(
				mineralResourceService.listMineralResources(pageable), "/resources");



		model.addAttribute("listMineralResources", resourcesPage);

		return "resources/index";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getResourceById(Model model) {
		return "resources/show";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String resourcesAdmin(Model model, Pageable pageable,
			@RequestParam(value = "enteredBy", required = false) String enteredBy,
			@RequestParam(value = "entryDate", required = false) @DateTimeFormat(iso = ISO.DATE) Date entryDate,
			@RequestParam(value = "range", defaultValue = "week") Range range) {

		if (entryDate == null) {
			entryDate = new Date();
		}
		int calendarEnum;
		int calendarValue;
		switch (range) {
		case week:
			calendarEnum = Calendar.DAY_OF_YEAR;
			calendarValue = 7;
			break;
		case month:
			calendarEnum = Calendar.MONTH;
			calendarValue = 1;
			break;
		case year:
			calendarEnum = Calendar.YEAR;
			calendarValue = 1;
			break;
		case all:
			calendarEnum = Calendar.YEAR;
			calendarValue = 100;
			break;
		default:
			calendarEnum = Calendar.DAY_OF_YEAR;
			calendarValue = 7;
			break;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(entryDate);
		calendar.add(calendarEnum, -calendarValue);
		Date startDate = calendar.getTime();
		calendar.setTime(entryDate);
		calendar.add(calendarEnum, calendarValue);
		Date endDate = calendar.getTime();

		Paginator<MineralResource> resourcesPage = new Paginator<MineralResource>(
				mineralResourceService.listMineralResourcesForAdministration(pageable, enteredBy, startDate, endDate),
				"/resources/admin");

		model.addAttribute("listMineralResources", resourcesPage);

		return "resources/admin";
	}

	@RequestMapping(value = "/qa", method = RequestMethod.POST)
	public void resourcesQualityCheck(Model model) {

	}

	private enum Range {
		week, month, year, all
	}

}
