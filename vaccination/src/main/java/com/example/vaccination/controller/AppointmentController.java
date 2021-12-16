package com.example.vaccination.controller;
import com.example.vaccination.schema.Appointments;
import com.example.vaccination.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

public class AppointmentController {
    @Autowired
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(value="/createAppointment", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<?> createAppointment(@RequestParam Map<String, String> params, Appointments appointment) {
        try {
            Appointments persistedAppointment = appointmentService.createAppointment(appointment);
            return ResponseEntity.accepted().body(persistedAppointment);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping(value="/getAppointments", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<?> getAppointments(@RequestParam(value = "userId") String userId) {
        try {
            List<Appointments> persistedAppointment = appointmentService.getAppointments(userId);
            return ResponseEntity.accepted().body(persistedAppointment);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @DeleteMapping(value="/deleteAppointment", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<?> deleteAppointment(@RequestParam(value = "appointmentId") String appointmentId) {
        try {
            String persistedAppointment = appointmentService.deleteAppointment(appointmentId);
            return ResponseEntity.accepted().body(persistedAppointment);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @PutMapping(value="/updateAppointment", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<?> updateAppointment(@RequestParam Map<String, String> params, Appointments appointment, @PathVariable("appointmentId") String appointmentId ) {
        try {
            Appointments persistedAppointment = appointmentService.updateAppointment(appointment, appointmentId);
            return ResponseEntity.accepted().body(persistedAppointment);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }







}
