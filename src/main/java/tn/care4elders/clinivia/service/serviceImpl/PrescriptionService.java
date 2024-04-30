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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
prescription.setDoctor_name(userS.getUserById(prescription.getDoctor_id()).getName());

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
        prescription.setDoctor_name(userS.getUserById(prescription.getDoctor_id()).getName());

        prescription.setApproved(true);


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


    public static List<String> extractWords(String str) {
        List<String> words = new ArrayList<>();

        // Regular expression to match words (alphanumeric characters and commas)
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(str);

        // Iterate through matches and add them to the list
        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }
    //api
    public Prescription generatePrescription(Prescription prescription ) {
       Patient patient = patientS.getPatientById(prescription.getPpatient_id());
       String symptoms = prescription.getSymptoms();
// Remove formatting characters and split the string
        List<String> symptomsList =extractWords(symptoms);

        String medicalHistory = patient.getMedicalHistory();
        List<String> suggestedMedications = analyzeData(medicalHistory, symptomsList);


        prescription.setTitle("Generated Prescription "+ prescription.getId());
        prescription.setSymptoms(String.join(", ", symptomsList));
        prescription.setApproved(false);
        prescription.setPatient(patient);
        prescription.setCreatedDate(new Date());
        prescription.setEmailPatient(patient.getEmail());
        prescription.setSuggestedMedicines(
                String.join(", ", suggestedMedications));

        return (Prescription) prescriptionRepo.save(prescription);
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

    @Override
    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionRepo.findByPatientId(patientId);
    }

    @Override
    public List<Prescription> getPrescriptionsByDoctorId(Long doctorId) {
        return prescriptionRepo.findByDoctorId(doctorId);
    }

    @Override
    public List<Integer> calculatePrescriptionStatisticsForDoctor(Long doctorId) {
        List<Integer> statistics = new ArrayList<>();
        int writtenPrescriptions = 0;
        int approvedPrescriptions = 0;
        List<Prescription> total_Prescriptions = this.getPrescriptionsByDoctorId(doctorId);

        for (Prescription pres : total_Prescriptions) {
            if (pres.getSuggestedMedicines() == null) {
                // 1. Number of prescriptions with suggestedMedicine empty
                writtenPrescriptions = writtenPrescriptions + 1;
            } else {
                // 2. Number of approved prescriptions
                approvedPrescriptions = approvedPrescriptions + 1;
            }
        }
        // 3. Total number of prescriptions
        int totalPrescriptions = this.getAllPrescriptions().size();

        // 4. Calculate the rest
        int restPrescriptions = totalPrescriptions - (writtenPrescriptions + approvedPrescriptions);

        statistics.add(writtenPrescriptions);
        statistics.add(approvedPrescriptions);
        statistics.add(restPrescriptions);

        return statistics;
    }



    public List<Prescription> getAllUnapproved(){
        return (List<Prescription>) prescriptionRepo.findAllByApprovedFalse();


    }

    }