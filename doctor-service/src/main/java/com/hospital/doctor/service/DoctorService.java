package com.hospital.doctor.service;

import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor create(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAll(){
        return doctorRepository.findAll();
    }
    public Doctor getById(Long id){
        return doctorRepository.findById(id).orElse(null);
    }
    public Doctor update(Long id, Doctor doctor){
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public void delete(Long id){
        doctorRepository.deleteById(id);
    }

}
