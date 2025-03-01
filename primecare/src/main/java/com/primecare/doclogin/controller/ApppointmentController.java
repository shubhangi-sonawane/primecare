package com.primecare.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primecare.doclogin.entity.Appointment;
import com.primecare.doclogin.repository.Appointmentrepository;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("http://localhost:4200")

public class ApppointmentController {
	Appointmentrepository appointmentrepository;

	public ApppointmentController(Appointmentrepository appointmentrepository) {
		super();
		this.appointmentrepository = appointmentrepository;
	}
	
@PostMapping("/insert")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
     return appointmentrepository.save(appointment);
}
@GetMapping
public List<Appointment> getAllAppointment(){
	return appointmentrepository.findAll();
}
@DeleteMapping("/appointments/{id}")
public ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
	Appointment appointment=appointmentrepository.findById(id).orElseThrow ( ()-> new AttributeNotFoundException("Appointment not found with id"+id));
	appointmentrepository.delete(appointment);
	Map<String,Boolean> response=new HashMap<String,Boolean>();
	response.put("Deleted", Boolean.TRUE);
	
	return ResponseEntity.ok(response);
} 
}
