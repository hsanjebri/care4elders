package tn.care4elders.clinivia.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.repository.FuneralRepository;
import tn.care4elders.clinivia.repository.PatientRepository;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.entity.Funeral;
import tn.care4elders.clinivia.service.FuneralService;

import java.util.Optional;
import java.util.List;

@Service
public class FuneralServiceImpl implements FuneralService {
    FuneralRepository funeralRepository;
    PatientRepository patientRepository;

    @Autowired
    public FuneralServiceImpl(FuneralRepository funeralRepository, PatientRepository patientRepository) {
        this.funeralRepository = funeralRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Funeral addFuneralForPatient(Long IdPatient, Funeral funeral) {
        Optional<Patient> patientOptional = patientRepository.findById(IdPatient);

        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            funeral.setPatient(patient);
            return funeralRepository.save(funeral);
        } else {
            // Handle patient not found, for example, by returning null or throwing another exception
            return null;
        }
    }

    @Override
    public Funeral updateFuneralForPatient(Long IdPatient, Funeral funeral) {
        Optional<Funeral> existingFuneral = funeralRepository.findById(IdPatient);

        if (existingFuneral.isPresent()) {
            funeral.setId(existingFuneral.get().getId());
            funeral.setPatient(existingFuneral.get().getPatient());
            return funeralRepository.save(funeral);
        } else {
            // Handle funeral not found, for example, by returning null or throwing another exception
            return null;
        }
    }

    @Override
    public void deleteFuneralForPatient(Long IdPatient) {
        Optional<Funeral> existingFuneral = funeralRepository.findById(IdPatient);

        existingFuneral.ifPresent(funeralRepository::delete);
    }

    @Override
    public Optional<Funeral> getFuneralForPatient(Long IdPatient) {
        return funeralRepository.findById(IdPatient);
    }

    @Override
    public List<Funeral> getAllFunerals() {
        return funeralRepository.findAll();
    }
}
