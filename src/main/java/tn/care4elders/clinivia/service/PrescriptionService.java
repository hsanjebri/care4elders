package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    Prescription addPrescription(Prescription prescription );

    List<Prescription> getAllPrescriptions();
    Prescription getPrescriptionById(long idPrescription);
    void deletePrescription(long idPrescription);

    Prescription updatePrescription( Prescription prescription);

    Prescription addMedicinesToPrescription(Long prescriptionId, List<Long> medicineIds);
     List<Medicine> getMedicinesByPrescriptionId(Long prescriptionId) ;
    public List<Prescription> getAllUnapproved();

    public Prescription generatePrescription(Prescription prescription) ;

    List<Prescription> getPrescriptionsByPatientId(Long patientId);

    List<Prescription> getPrescriptionsByDoctorId(Long doctorId);
     List<Integer> calculatePrescriptionStatisticsForDoctor(Long doctorId) ;

    }
