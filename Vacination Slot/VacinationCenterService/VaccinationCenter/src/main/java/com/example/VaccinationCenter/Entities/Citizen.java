package com.example.VaccinationCenter.Entities;

public class Citizen {
	int id;
	String name;
	private int vaccinationId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVaccinationId() {
		return vaccinationId;
	}
	public void setVaccinationId(int vaccinationId) {
		this.vaccinationId = vaccinationId;
	}
	
	
}
