package tn.care4elders.clinivia.service.serviceImpl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Alergie;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.repository.PatientRepository;
import tn.care4elders.clinivia.service.PatientService;
import tn.care4elders.clinivia.entity.Task;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PatientServiceImpl implements PatientService {


     PatientRepository  patientRepository;


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

    @Override
    public double calculateTaskCompletionPercentage(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null || patient.getTasks() == null || patient.getTasks().isEmpty()) {
            return 0.0;
        }

        int totalTasks = patient.getTasks().size();
        long completedTasks = patient.getTasks().stream().filter(Task::isDone).count();

        return ((double) completedTasks / totalTasks) * 100.0;
    }
//shadha
@Override
public Patient getPatientByEmail(String email) {
    return patientRepository.findByEmail(email);
}



    public void displayRarestBloodTypeDistribution() {
        List<Patient> patients = patientRepository.findAll();

        // Define the top 3 rarest blood types
        List<String> rarestBloodTypes = Arrays.asList("AB-", "B-", "AB+");

        Map<String, Long> bloodTypeCounts = patients.stream()
                .map(Patient::getBGroupe)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Display the count for each of the top 3 rarest blood types
        System.out.println("Rarest Blood Type Distribution among Top 3 Rarest Blood Types:");
        for (String bloodType : rarestBloodTypes) {
            System.out.println(bloodType + ": " + bloodTypeCounts.getOrDefault(bloodType, 0L));
        }
    }
    public Map<Alergie, Integer> countCommonPatientAllergies(List<Patient> patients) {
        Map<Alergie, Integer> allergyCounts = new HashMap<>();

        for (Patient patient : patients) {
            Alergie patientAllergy = patient.getPatientAlergies();
            if (patientAllergy != null) {
                allergyCounts.put(patientAllergy, allergyCounts.getOrDefault(patientAllergy, 0) + 1);
            }
        }

        return allergyCounts;
    }
}
