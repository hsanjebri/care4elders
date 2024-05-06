package tn.care4elders.clinivia.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.repository.FuneralRepository;
import tn.care4elders.clinivia.repository.PatientRepository;
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
    public class PatientNotFoundException extends RuntimeException {

        public PatientNotFoundException(String message) {
            super(message);
        }
    }
    @Override
    public Funeral addFuneral( Funeral funeral) {
        Optional<Patient> patientOptional = patientRepository.findById(Long.valueOf(funeral.getIdPatient()));
        if (patientOptional.isPresent()) {
            // Patient exists, save the funeral
            return funeralRepository.save(funeral);
        } else {
            // Patient doesn't exist, throw an exception or return an error message
            throw new PatientNotFoundException("Patient with IdPatient: " + funeral.getIdPatient() + " not found");
        }
    }


    @Override
    public Funeral updateFuneral( Funeral funeral) {

            return funeralRepository.save(funeral);
    }

    @Override
    public void deleteFuneralById(Long IdFuneral) {
        funeralRepository.deleteById(IdFuneral);
    }

    @Override
    public Optional<Funeral> getFuneralById(long IdFuneral){

        return funeralRepository.findById(IdFuneral);
    }

    @Override
    public List<Funeral> getAllFunerals() {
        return funeralRepository.findAll();
    }
}
