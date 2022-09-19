package com.example.CitizenService.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.CitizenService.Entity.Citizen;
	
	
	public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
		
		@Query("SELECT c FROM  Citizen c WHERE c.vaccinationId =:i" )
		public List<Citizen> findbyVaccinationId(@Param("i") int id) ;// return list of citizen under a particular vaccination center
		

	}



