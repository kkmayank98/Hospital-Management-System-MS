package com.hospital.appointment.controller;

import com.hospital.appointment.dto.AppointmentResponse;
import com.hospital.appointment.model.Appointment;
import com.hospital.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/details/{id}")
    public AppointmentResponse getAppointmentDetails(@PathVariable Long id) {
        return appointmentService.getAppointmentDetails(id);
    }
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment saved = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id,
                                                         @RequestBody Appointment updatedAppointment) {
        Appointment updated = appointmentService.updateAppointment(id, updatedAppointment);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
