package com.primecare.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primecare.doclogin.entity.Appointment;

@Repository
public interface Appointmentrepository extends JpaRepository<Appointment,Long>{

}
