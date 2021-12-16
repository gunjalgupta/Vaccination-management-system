package com.example.vaccination.service;

import com.example.vaccination.repository.AppointmentRepository;
import com.example.vaccination.repository.DiseaseRepository;
import com.example.vaccination.repository.PatientVaccinationRepository;
import com.example.vaccination.repository.VaccineRepository;
import com.example.vaccination.schema.Appointments;
import com.example.vaccination.schema.Clinics;
import com.example.vaccination.schema.Diseases;
import com.example.vaccination.schema.Vaccines;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Service
//@SqlResultSetMapping(name="updatePassengerDetails", columns = { @ColumnResult(name = "count")})
//@NamedNativeQueries({
//        @NamedNativeQuery(
//                name    =   "updatePassengerDetails",
//                query   =   "UPDATE passenger SET firstname = ?, lastname = ?, phone=?, age = ?, gender = ? WHERE id = ?"
//                ,resultSetMapping = "updateResult"
//        )
//})
@Service
public class VaccineService {
    @Autowired // This means to get the bean called userRepository
    private VaccineRepository vaccineRepository;
    @Autowired // This means to get the bean called userRepository
    private DiseaseRepository diseaseRepository;
    @PostMapping
    public Vaccines createVaccine(Vaccines vaccineDetails, List<String> diseaseNumbers) throws Exception {
        Vaccines newVaccine = null;
        List<Diseases> diseases = new ArrayList<>();
        for(int i=0;i<diseaseNumbers.size();i++) {
            Diseases diseaseDetails = diseaseRepository.findByDid(diseaseNumbers.get(i));
            diseases.add(diseaseDetails);
        }
        vaccineDetails.setDiseaseId(diseases);
        try {
            newVaccine = vaccineRepository.save(vaccineDetails);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("constraint violation", ex);
        }
        return newVaccine;
    }


    @GetMapping
    public List<Vaccines> getVaccines() throws Exception {
        List<Vaccines> vaccineList = null;
        try {
            vaccineList = (List<Vaccines>) vaccineRepository.findAll();
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("constraint violation", ex);
        }
        return vaccineList;
    }
    @GetMapping
    public List<Vaccines> getFilteredVaccinesAndDiseases(String clinicId) throws Exception {
        List<Vaccines> filteredVaccinesDiseasesList = null;
        try {
            //logic for get vaccines and diseases based on clinicID
            //filteredVaccinesDiseasesList =  Get vaccine details for a clinic and get Disease details of each vaccine there is
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("constraint violation", ex);
        }
        return filteredVaccinesDiseasesList;
    }
}


