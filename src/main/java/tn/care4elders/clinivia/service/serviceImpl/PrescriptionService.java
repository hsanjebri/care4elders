package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.entity.Prescription;
import tn.care4elders.clinivia.repository.MedicineRepository;
import tn.care4elders.clinivia.repository.PrescriptionRepository;
import tn.care4elders.clinivia.service.IserviceUser;
import tn.care4elders.clinivia.service.PatientService;


import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PrescriptionService implements tn.care4elders.clinivia.service.PrescriptionService {

    PrescriptionRepository prescriptionRepo  ;
    PatientService patientS ;
    MedicineRepository medicineRepository;
    IserviceUser userS ;


    @Override
    public Prescription addPrescription(Prescription prescription ) {
        prescription.setPatient(patientS.getPatientByEmail(prescription.getEmailPatient()));
        prescription.setDoctor(userS.getUserById(prescription.getDoctor_id()));


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
        Optional<Prescription> optionalPrescription = prescriptionRepo.findById(idPrescription);
        if (optionalPrescription.isPresent()) {
            Prescription prescription = optionalPrescription.get();
            prescription.getMedicines().clear(); // Clear the list of associated medicines


            prescriptionRepo.save(prescription); // Save the updated prescription without medicines
            prescriptionRepo.deleteById(idPrescription); // Delete the prescription
        } else {
            throw new RuntimeException("Prescription not found with id: " + idPrescription);
            // Handle this exception based on your application's requirements
        }
    }



    @Override
    public Prescription updatePrescription( Prescription prescription) {
        prescription.setPatient(patientS.getPatientByEmail(prescription.getEmailPatient()));
        prescription.setDoctor(userS.getUserById(prescription.getDoctor_id()));

        return (Prescription) prescriptionRepo.save(prescription);



    }

    public Prescription addMedicinesToPrescription(Long prescriptionId, List<Long> medicineIds) {
        // Fetch the prescription by ID
        Prescription prescription = prescriptionRepo.findById(prescriptionId)
                .orElseThrow(() -> new RuntimeException("Prescription not found for this id :: " + prescriptionId));

        // Fetch each medicine by ID and add it to the prescription
        medicineIds.forEach(id -> {
            Medicine medicine = medicineRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Medicine not found for this id :: " + id));
            prescription.getMedicines().add(medicine);
        });

        return prescriptionRepo.save(prescription); // Save the updated prescription
    }

    public List<Medicine> getMedicinesByPrescriptionId(Long prescriptionId) {
        Prescription prescription = prescriptionRepo.findById(prescriptionId)
                .orElseThrow(() -> new RuntimeException("Prescription not found for this id :: " + prescriptionId));
        return prescription.getMedicines();
    }



    //api
    public Prescription generatePrescription(Long id, List<String> symptoms) {
       Patient patient = patientS.getPatientById(id);
        String medicalHistory = patient.getMedicalHistory();
        List<String> suggestedMedications = analyzeData(medicalHistory, symptoms);


        Prescription prescription = new Prescription();
        prescription.setTitle("Generated Prescription");
        prescription.setDiseases(String.join(", ", symptoms));
        prescription.setApproved(false);
        prescription.setPatient(patient);
        prescription.setCreatedDate(new Date());
        prescription.setEmailPatient(patient.getEmail());
        prescription.setSuggestedMedicines("Suggested medications: " + String.join(", ", suggestedMedications));

        return prescription;
    }



    private List<String> analyzeData(String medicalHistory, List<String> symptoms) {
        Set<String> suggestedMedications = new HashSet<>();


        // Check if the patient has a history of hypertension
        if (medicalHistory != null && medicalHistory.contains("hypertension")) {
            for (String symptom : symptoms) {
                if (symptom.equalsIgnoreCase("headache")) {
                    suggestedMedications.add("Acetaminophen (e.g., Tylenol)");
                }
                if (symptom.equalsIgnoreCase("stomach ache")) {
                    suggestedMedications.add("Antacid (e.g., Tums)");
                    suggestedMedications.add("Antispasmodic (e.g., Buscopan)");

            }
        }}

        // Check if the patient has a history of diabetes
        if (medicalHistory != null && medicalHistory.contains("diabetes")) {
            for (String symptom : symptoms) {
                if (symptom.equalsIgnoreCase("fatigue")) {
                    suggestedMedications.add("Glucose tablets");
                    suggestedMedications.add("Insulin");
                }
                if (symptom.equalsIgnoreCase("headache")) {
                    suggestedMedications.add("Acetaminophen (e.g., Tylenol)");
                }
                if (symptom.equalsIgnoreCase("changes in weight")) {
                    suggestedMedications.add("Metformin");
                    suggestedMedications.add("SGLT2 inhibitors");

            }
        }}

        // Check if the patient has a history of hyperlipidemia
        if (medicalHistory != null && medicalHistory.contains("hyperlipidemia")) {
            for (String symptom : symptoms) {
                if (symptom.equalsIgnoreCase("chest pain")) {
                    suggestedMedications.add("Statin medications (e.g., Atorvastatin)");
                    suggestedMedications.add("Ezetimibe");
                }
                if (symptom.equalsIgnoreCase("shortness of breath")) {
                    suggestedMedications.add("Aspirin");
                    suggestedMedications.add("Statins");
                }
            }
        }

        // If there's no relevant medical history, suggest medications based on symptoms only
        if (medicalHistory == null) {
            for (String symptom : symptoms) {
                if (symptom.equalsIgnoreCase("fatigue")) {
                    suggestedMedications.add("Vitamin B complex");
                    suggestedMedications.add("Iron supplements");
                } else if (symptom.equalsIgnoreCase("headache")) {
                    suggestedMedications.add("Acetaminophen (e.g., Tylenol)");
                } else {
                    suggestedMedications.add("General Medication");
                }
            }
        }
            List<String> suggestedMedicationsSet = new ArrayList<>(suggestedMedications);

        return suggestedMedicationsSet;
    }


}
