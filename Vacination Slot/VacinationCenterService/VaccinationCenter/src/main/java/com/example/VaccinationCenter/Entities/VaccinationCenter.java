package com.example.VaccinationCenter.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
	
	
	
		
		
		@Id
		private int id;
		private String centerName  ;
		private String centerAddress;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCenterName() {
			return centerName;
		}
		public void setCenterName(String centerName) {
			this.centerName = centerName;
		}
		public String getCenterAddress() {
			return centerAddress;
		}
		public void setCenterAddress(String centerAddress) {
			this.centerAddress = centerAddress;
		}
		

}
