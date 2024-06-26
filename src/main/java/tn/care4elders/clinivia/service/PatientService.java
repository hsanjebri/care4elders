package tn.care4elders.clinivia.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Alergie;
import tn.care4elders.clinivia.entity.Patient;

import java.util.List;
import java.util.Map;


public interface PatientService {

    Patient savePatient(Patient patient);

    // Récupérer un patient par son ID
    Patient getPatientById(long id);


    // Supprimer un patient par son ID
    void deletePatient(long id);

    // Récupérer tous les patients
    List<Patient> getAllPatients();


    public Patient updatePatient( Patient patient);
    double calculateTaskCompletionPercentage(long patientId);
    public void displayRarestBloodTypeDistribution() ;

    public  Map<Alergie, Integer> countCommonPatientAllergies(List<Patient> patients) ;

    //shadha
    Patient getPatientByEmail(String address);
}
