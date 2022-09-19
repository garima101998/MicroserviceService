package com.example.VaccinationCenter.Controlller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VaccinationCenter.Entities.Citizen;
import com.example.VaccinationCenter.Entities.RequiredResponse;
import com.example.VaccinationCenter.Entities.VaccinationCenter;
import com.example.VaccinationCenter.Service.VaccinationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	
	@Autowired
	private VaccinationService vs; 
	
	    @PostMapping("/add")
		public void addVaccinationCenter(@RequestBody VaccinationCenter c)
		{
	    	System.out.print(c.getId()+" "+c.getCenterAddress()+" "+c.getCenterName());
			
	     vs.addVaccinationCenter(c);
	     
		}
	    
	   
	    public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id) {
	    	RequiredResponse r=new RequiredResponse();
	    	 
	    	r.setVaccinationCenter(vs.getVaccinationCenterDetails(id))    ;
	    	return new ResponseEntity<RequiredResponse>(r,null, HttpStatus.SC_OK);
	    	
	    	
}

	    @GetMapping("/getCitizens/{id}")
	    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	    public ResponseEntity<RequiredResponse> getAllCitizen( @PathVariable Integer id)
	    {
	       	RequiredResponse r=new RequiredResponse();
	    	List<Citizen> l=vs.getAllCitizen(id);
	    	VaccinationCenter v=vs.getVaccinationCenterDetails(id) ;
	    	
	    	r.setCitizen(l);
	    	r.setVaccinationCenter(v);
	    	
	    	return new ResponseEntity<RequiredResponse>(r,null, HttpStatus.SC_OK);
	    }

}
