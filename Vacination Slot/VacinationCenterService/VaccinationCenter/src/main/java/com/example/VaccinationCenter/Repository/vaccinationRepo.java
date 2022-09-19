package com.example.VaccinationCenter.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VaccinationCenter.Entities.VaccinationCenter;



public interface vaccinationRepo extends JpaRepository<VaccinationCenter,Integer>{

}
