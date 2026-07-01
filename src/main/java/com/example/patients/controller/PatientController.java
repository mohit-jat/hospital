package com.example.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patients.entity.Patient;
import com.example.patients.service.PatientService;


@RestController
@RequestMapping("patient")
public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping
	public List<Patient> getpatien() {
		return service.readAll();

	}

	@GetMapping("/{id}")
	public Patient getonepatien(@PathVariable Long id) {
		return service.getone(id);

	}

	@PostMapping
	public Patient savepatien(@RequestBody Patient st) {

		return service.insert(st);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {

		service.delete(id);

		return "delete successfully";

	}

	@PutMapping("/{id}")
	public Patient updatepatien(@PathVariable Long id, @RequestBody Patient patien) {

		return service.updatepatien(id, patien);

	}

}