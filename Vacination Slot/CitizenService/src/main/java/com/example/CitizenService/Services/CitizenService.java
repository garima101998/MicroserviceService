package com.example.CitizenService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CitizenService.Entity.Citizen;
import com.example.CitizenService.Repositories.CitizenRepo;
@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepo cr;

	public void SaveCitizen(Citizen c)
	{
		cr.save(c);
	}
	
	
	
	public List<Citizen> findbyVaccinationId(int id)
	{
		return cr.findbyVaccinationId(id);
	}
}
