package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Prescription;
import tn.care4elders.clinivia.repository.MedicineRepository;
import tn.care4elders.clinivia.repository.PrescriptionRepository;
import tn.care4elders.clinivia.service.PatientService;


import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PrescriptionService implements tn.care4elders.clinivia.service.PrescriptionService {
    PrescriptionRepository prescriptionRepo  ;
    PatientService patientS ;

     MedicineRepository medicineRepository;




    @Override
    public Prescription addPrescription(Prescription prescription ) {
        prescription.setPatient(patientS.getPatientByAddress(prescription.getEmailPatient()));
       /* for (Medicine medicine : prescription.getAllmedicines()) {
            medicineRepository.save(medicine);
        }
        prescription.setMedicines(prescription.getAllmedicines()); // Establish bidirectional relationship*/

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
