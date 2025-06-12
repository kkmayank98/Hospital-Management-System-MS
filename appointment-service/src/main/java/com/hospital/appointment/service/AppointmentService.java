package com.hospital.appointment.service;

import com.hospital.appointment.client.DoctorClient;
import com.hospital.appointment.client.PatientClient;
import com.hospital.appointment.dto.AppointmentResponse;
import com.hospital.appointment.dto.DoctorDTO;
import com.hospital.appointment.dto.PatientDTO;
import com.hospital.appointment.model.Appointment;
import com.hospital.appointment.repository.AppointmentRepository;
import com.netflix.discovery.converters.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

    public AppointmentResponse getAppointmentDetails(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Fetch doctor and patient details using Feign clients
         DoctorDTO doctor = doctorClient.getDoctorById(appointment.getDoctorId());
         PatientDTO patient = patientClient.getPatientById(appointment.getPatientId());
        // Create and return the response object
        return new AppointmentResponse(appointment,patient, doctor);
        
    }
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        existing.setDoctorId(updatedAppointment.getDoctorId());
        existing.setPatientId(updatedAppointment.getPatientId());
        existing.setDate(updatedAppointment.getDate());

        return appointmentRepository.save(existing);
    }


}
