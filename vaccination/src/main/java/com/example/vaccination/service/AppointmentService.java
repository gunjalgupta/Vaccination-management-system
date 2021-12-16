package com.example.vaccination.service;
import com.example.vaccination.repository.AppointmentRepository;
import com.example.vaccination.repository.PatientVaccinationRepository;
import com.example.vaccination.schema.Appointments;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.UUID;

@Service
//@SqlResultSetMapping(name="updatePassengerDetails", columns = { @ColumnResult(name = "count")})
//@NamedNativeQueries({
//        @NamedNativeQuery(
//                name    =   "updatePassengerDetails",
//                query   =   "UPDATE passenger SET firstname = ?, lastname = ?, phone=?, age = ?, gender = ? WHERE id = ?"
//                ,resultSetMapping = "updateResult"
//        )
//})

public class AppointmentService {
    @Autowired // This means to get the bean called userRepository
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public @ResponseBody
    List<Appointments> getAppointments(String userId){
        return appointmentRepository.findAllByUserId(userId);
    }

    @PostMapping
    public Appointments createAppointment(Appointments appointmentDetails) throws Exception {
        Appointments newAppointment = null;
        try {
            newAppointment = appointmentRepository.save(appointmentDetails);
        }
        catch(DataIntegrityViolationException ex){
            throw new Exception("constraint violation", ex);
        }
        return newAppointment;
    }

    @PutMapping()
    public Appointments updateAppointment(Appointments appointmentDetails, String appointmentId) throws Exception {
        Appointments existingAppointment = null;
        try{
            existingAppointment = appointmentRepository.findByAid(appointmentId);
            existingAppointment.setFromTime(appointmentDetails.getFromTime());
            existingAppointment.setToTime(appointmentDetails.getToTime());
            existingAppointment.setUserId(appointmentDetails.getUserId());
            existingAppointment.setClinicId(appointmentDetails.getClinicId());
            existingAppointment.setVaccineId(appointmentDetails.getVaccineId());
            appointmentRepository.save(existingAppointment);
        }
        catch(DataIntegrityViolationException ex){
            System.out.println("Already exists");
            throw new Exception("constraint violation", ex);
        }
        return existingAppointment;
    }

    @DeleteMapping()
    public String deleteAppointment(String appointmentId) {
        Appointments existingAppointment = appointmentRepository.findByAid(appointmentId);
        if(existingAppointment!=null){
            appointmentRepository.deleteByAid(appointmentId);
            return "Deleted Successfully";
        }
        return "-1";
    }
}