package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription addPrescription(Prescription Prescription);
    List<Prescription> getAllPrescriptions();
    Prescription getPrescriptionById(long idPrescription);
    void deletePrescription(long idPrescription);
    Prescription updatePrescription(Prescription Prescription);

}
