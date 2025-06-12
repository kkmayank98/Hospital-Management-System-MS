package com.hospital.patient.service;

import com.hospital.patient.entity.Patients;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patients> getAllPatients(){
        return patientRepository.findAll();
    }
    public Optional<Patients> getPatientById(Long id){
        return  patientRepository.findById(id);
    }

    public Patients savePatient(Patients patients){
        return patientRepository.save(patients);
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
