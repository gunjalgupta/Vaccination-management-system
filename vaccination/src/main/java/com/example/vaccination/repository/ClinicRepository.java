package com.example.vaccination.repository;

import com.example.vaccination.schema.Appointments;
import com.example.vaccination.schema.Clinics;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ClinicRepository  extends CrudRepository<Clinics, Integer> {
    Clinics findByCid(String id);
    void deleteByCid(String id);

}
