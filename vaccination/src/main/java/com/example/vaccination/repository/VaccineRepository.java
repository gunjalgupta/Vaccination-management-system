package com.example.vaccination.repository;

import com.example.vaccination.schema.Appointments;
import com.example.vaccination.schema.Diseases;
import com.example.vaccination.schema.Vaccines;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VaccineRepository  extends CrudRepository<Vaccines, Integer> {
    Vaccines findByVid(String id);
    void deleteByVid(String id);
}
