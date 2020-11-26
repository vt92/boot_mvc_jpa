package com.vt.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vt.location.entities.Location;
import com.vt.location.repos.LocationRepository;
import com.vt.location.service.LocationService;
import com.vt.location.util.EmailUtil;
import com.vt.location.util.ReportUtil;

@Controller
public class LocationController {
	@Autowired
	LocationService locationService;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	EmailUtil emailUtil;
	@Autowired
	ReportUtil reportUtil;
	@Autowired //to pass the path for report generation
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate(){
		return "createLocation";
	} 
	//to handle the reuqest we have modelattribute
	//to handle response we have modelmap
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = locationService.saveLocation(location);
		String msg = "Location saved with id: "+locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		//sending email configuration
		emailUtil.sendEmail("testemail150847@gmail.com", "Location Subject", "Location Body");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocation")
	public String displayLocation(ModelMap modelMap) {
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		//Location location = locationService.getLocationById(id); //can also be used
		Location location = new Location();
		location.setId(id);
		locationService.deleteLocation(location);
		
		//after deletion we want to display the same page with complete list
		//so do following extra steps for that
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		
		return "displayLocation"; //we want to go back to display loc page
	}
	
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateloc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = locationRepository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
	
	
}
