package com.example.VaccinationCenter.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.VaccinationCenter.Entities.VaccinationCenter;
import com.example.VaccinationCenter.Entities.Citizen;
import com.example.VaccinationCenter.Repository.vaccinationRepo;



@Service
public class VaccinationService {
	
    @Autowired
	private vaccinationRepo vr;
    
    @Autowired
    private RestTemplate restTemp; 
    
	public void addVaccinationCenter(VaccinationCenter c)
	{
		vr.save(c);

    }
//	public Optional<VaccinationCenter> getVaccinationCenterDetails(int id)
//	{
//		 Optional<VaccinationCenter> g=vr.findById(id);
//		 return g;
//		
//
//
//	}
	public VaccinationCenter getVaccinationCenterDetails(int id)
	{
		VaccinationCenter v;
		v=vr.findById(id).get();
		
		return v;
	}
	public List<Citizen> getAllCitizen(int id){
      List<Citizen> l=restTemp.getForObject("http://localhost:8010/citizen/id/"+id, List.class);
     
	
//	 for(Citizen c:l)
//	 {
//		 System.out.println(c.getId()+" "+c.getName()+" "+c.getVaccinationId());
//     }
	 return l;
	}
}