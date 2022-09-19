package com.example.CitizenService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CitizenService.Entity.Citizen;
import com.example.CitizenService.Services.CitizenService;

@RestController 
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	CitizenService cr;
	
	@GetMapping("/id/{id}") //taking vaccination id and returing all citizen enroll under that 
	public List<Citizen> getById(@PathVariable Integer id)
	{
		//get Vaccination Center Details
		//get All citizen register to vaccination center
		List<Citizen> list =cr.findbyVaccinationId(id);
		
		return list;
		
		
	}
	
    @PostMapping("/add")
	public void addCitizen(@RequestBody Citizen c)
	{
		System.out.print(c.getId()+" ");
		System.out.print(c.getName()+" ");
		System.out.print(c.getVaccinationId());
	cr.SaveCitizen(c);
		
	}

}
