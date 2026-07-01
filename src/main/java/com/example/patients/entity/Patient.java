package com.example.patients.entity;

import java.time.LocalDate;

import com.example.patients.enumm.BillStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String name;

	private LocalDate date;

	private String diagonse;

	private Double billamount;
	private String Doctername;
	private LocalDate admitdate;
	private LocalDate dischargedate;
	@Enumerated(EnumType.STRING)
	private BillStatus status;

	public Patient(String name, LocalDate date, String diagonse, Double billamount, String doctername,
			LocalDate admitdate, LocalDate dischargedate) {
		super();
		this.name = name;
		this.date = date;
		this.diagonse = diagonse;
		this.billamount = billamount;
		Doctername = doctername;
		this.admitdate = admitdate;
		this.dischargedate = dischargedate;
	}

}
