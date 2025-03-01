package com.primecare.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primecare.doclogin.entity.Medicine;

@Repository
public interface Medicinerepository extends JpaRepository<Medicine,Long>{

}
