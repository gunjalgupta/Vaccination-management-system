package com.example.vaccination.repository;

import com.example.vaccination.schema.Appointments;
import com.example.vaccination.schema.Diseases;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DiseaseRepository  extends CrudRepository<Diseases, Integer> {
    Diseases findByDid(String id);
    void deleteByDid(String id);
}
