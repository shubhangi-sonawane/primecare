package com.primecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primecare.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
	

}
