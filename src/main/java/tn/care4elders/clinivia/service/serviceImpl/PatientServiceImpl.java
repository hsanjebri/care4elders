package tn.care4elders.clinivia.service.serviceImpl;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.repository.PatientRepository;
import tn.care4elders.clinivia.service.PatientService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PatientServiceImpl implements PatientService {


     PatientRepository patientRepository;


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null);
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient( Patient patient) {
        return patientRepository.save(patient);

    }


}
