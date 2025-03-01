package com.primecare.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primecare.entity.Patient;
import com.primecare.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class PatientController {
	 private  PatientRepository PatientRepository;

	public PatientController(com.primecare.repository.PatientRepository patientRepository) {
		super();
		this.PatientRepository = patientRepository;
	}
	@PostMapping("/patients")
	 public Patient createpatient(@RequestBody Patient patient) {
		return PatientRepository.save(patient);
	 

	}

	@GetMapping("/patients")
	public List<Patient>getAllPatient(){
		return PatientRepository.findAll();
	}@GetMapping("patients/{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient=PatientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient not found with id :"+id));
		return ResponseEntity.ok(patient);
		
	}
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>>deletePatient(@PathVariable long id) throws AttributeNotFoundException{
	Patient Patient=PatientRepository.findById(id).orElseThrow ( ()->new AttributeNotFoundException("patient not found with id :"+id) );
    PatientRepository.delete(Patient);
	Map<String, Boolean> response=new HashMap<String, Boolean>();
	response.put("Deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient>updatePatientById(@PathVariable long id,@RequestBody Patient patientDetails) throws AttributeNotFoundException{
	
	Patient patient=PatientRepository.findById(id).orElseThrow( ()->new AttributeNotFoundException("patient not found with id :"+id) );
	 
	patient.setAge(patientDetails.getAge());
	patient.setName(patientDetails.getName());
	patient.setBlood(patientDetails.getBlood());
	patient.setDose(patientDetails.getDose());
	patient.setFees(patientDetails.getFees());
	patient.setPrescription(patientDetails.getPrescription());
	patient.setUrgency(patientDetails.getUrgency());
	
Patient savePatient	=PatientRepository.save(patient);
return ResponseEntity.ok(savePatient);
	
}
}