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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primecare.doclogin.entity.Medicine;
import com.primecare.doclogin.repository.Medicinerepository;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {
	Medicinerepository MedicineRepository;

	public MedicineController(Medicinerepository medicineRepository) {
		super();
		this.MedicineRepository = medicineRepository;
	}
	@PostMapping("/medicines")
	public Medicine createMedicine(@RequestBody Medicine medicine){
		
		return MedicineRepository.save(medicine);
	}
	@GetMapping("/medicines")
	public List<Medicine>getAllMedicine(){
return MedicineRepository.findAll();
	}
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine>getMedicineById(@PathVariable long id) throws AttributeNotFoundException{
	Medicine medicine=MedicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found with id "+id));
	return ResponseEntity.ok(medicine);
	}
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine>updateMedicineById(@PathVariable long id,@RequestBody Medicine medicineDetails) throws AttributeNotFoundException{
		Medicine medicine=MedicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found with id "+id));
		medicine.setdrugName(medicineDetails.getdrugName());
		medicine.setStock(medicineDetails.getStock());
		MedicineRepository.save(medicine);
		return ResponseEntity.ok(medicine);
	}
	@DeleteMapping("/medicines/{id}")
public ResponseEntity<Map<String,Boolean>>delete(@PathVariable long id) throws AttributeNotFoundException{
	Medicine medicine=MedicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found with id "+id));
MedicineRepository.delete(medicine);
Map<String,Boolean>response=new HashMap<String,Boolean>();
response.put("Delete", Boolean.TRUE);
return ResponseEntity.ok(response);


	
}
}
