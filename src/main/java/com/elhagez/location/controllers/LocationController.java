package com.elhagez.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elhagez.location.entities.Location;
import com.elhagez.location.repos.LocationRepository;
import com.elhagez.location.service.LocationService;
import com.elhagez.location.util.EmailUtil;
import com.elhagez.location.util.ReportUtil;


@Controller
public class LocationController {
	@Autowired
	LocationService service;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	ReportUtil reportUtil;
	

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location
			, ModelMap modelMap) {
		Location Locationsaved = service.saveLocation(location);
		String msg = "Location saved with id : " + Locationsaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("mostafahegzo291@gmail.com", "Location saved",
				"Location saved succesfully and about to return a responce");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations (ModelMap modelMap)     {
		List<Location> Locations = service.getAllLocations();
		modelMap.addAttribute("locations", Locations);
		return "displayLocations";
	}
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		Location locationById = service.getLocationById(id);
		service.deleteLocation(locationById);
		List<Location> Locations = service.getAllLocations();
		modelMap.addAttribute("locations", Locations);
		return "displayLocations";
	}

	
	@RequestMapping("/showUpdate")
	public String showUpdatePage(@RequestParam("id") int id ,ModelMap modelMap) {
		
		Location locationById = service.getLocationById(id);
		modelMap.addAttribute("locationById", locationById);
		return "editLocation";
	}
	
	@RequestMapping("/editloc")
	public String updateLocation(@ModelAttribute("location") Location location
			, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> Locations = service.getAllLocations();
		modelMap.addAttribute("locations", Locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
		
	}
	
}





































































































































