package com.example.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patients.entity.Patient;
import com.example.patients.repository.PatientRepository;



@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;

	public List<Patient> readAll(){
		return repo.findAll();
		
	}	
	
	
	
	public Patient getone(Long id) {
		
		return repo.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
	}

	
	
	public Patient insert(Patient st) {

		return  repo.save(st);
	}
	
	
	public Patient updatepatien(Long id, Patient patien) {
		
		
		return repo.findById(id).map(a->{
			
			a.setName(patien.getName());
			a.setStatus(patien.getStatus());
			
			a.setAdmitdate(patien.getAdmitdate());
			a.setBillamount(patien.getBillamount());
			
			a.setDiagonse(patien.getDiagonse());
			
			a.setDischargedate(patien.getDischargedate());
			
		    a.setDate(patien.getDate());
		    a.setDoctername(patien.getDoctername());
			
			return repo.save(a);
			
		}).orElseThrow(()-> new RuntimeException("not found"));
	
			
		}


	public void delete(Long id) {
		repo.deleteById(id);
	}


}
