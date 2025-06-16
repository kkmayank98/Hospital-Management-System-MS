package com.hospital.patient.controller;

import com.hospital.patient.entity.Patients;
import com.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/test")
    public String test() {
        return "Patient Service is working!";
    }
    @GetMapping
    public ResponseEntity<List<Patients>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Patients> getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Patients> savePatient(@RequestBody Patients patient) {
        return ResponseEntity.ok(patientService.savePatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
