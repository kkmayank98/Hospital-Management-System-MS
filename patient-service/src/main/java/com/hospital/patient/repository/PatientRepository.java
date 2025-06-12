package com.hospital.patient.repository;

import com.hospital.patient.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patients, Long> {

}
