package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    Prescription addPrescription(Prescription prescription );

    List<Prescription> getAllPrescriptions();
    Prescription getPrescriptionById(long idPrescription);
    void deletePrescription(long idPrescription);
    Prescription updatePrescription(Prescription Prescription);

}
