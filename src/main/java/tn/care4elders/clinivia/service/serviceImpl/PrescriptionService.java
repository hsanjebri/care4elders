package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Prescription;
import tn.care4elders.clinivia.repository.PrescriptionRepository;



import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PrescriptionService implements tn.care4elders.clinivia.service.PrescriptionService {
    PrescriptionRepository prescriptionRepo  ;

    @Override
    public Prescription addPrescription(Prescription prescription) {
        return (Prescription) prescriptionRepo.save(prescription);
    }
    @Override
    public List<Prescription> getAllPrescriptions() {
        return (List<Prescription>) prescriptionRepo.findAll();
    }
    @Override
    public Prescription getPrescriptionById(long idPrescription) {
        return (Prescription) prescriptionRepo.findById(idPrescription).get();
    }
    @Override
    public void deletePrescription(long idPrescription) {
        prescriptionRepo.deleteById(idPrescription);
    }
    @Override
    public Prescription updatePrescription(Prescription prescription) {
        return (Prescription) prescriptionRepo.save(prescription);
    }

}
