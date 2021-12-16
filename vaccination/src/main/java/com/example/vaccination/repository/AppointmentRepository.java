package com.example.vaccination.repository;

import com.example.vaccination.schema.Appointments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository  extends CrudRepository<Appointments, Integer> {
    Appointments findByAid(String id);
    void deleteByAid(String id);
    List<Appointments> findAllByUserId(String userId);
}
