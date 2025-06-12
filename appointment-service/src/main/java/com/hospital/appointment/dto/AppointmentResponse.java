package com.hospital.appointment.dto;

import com.hospital.appointment.model.Appointment;

public class AppointmentResponse {
    private Appointment appointment;
    private PatientDTO patient;
    private DoctorDTO doctor;

    public AppointmentResponse(Appointment appointment, PatientDTO patient, DoctorDTO doctor) {
        this.appointment = appointment;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }
}
