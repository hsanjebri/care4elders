package tn.care4elders.clinivia.service.serviceImpl;

import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Prescription;

import java.util.List;

public interface IPrescriptionService {
    Prescription addPrescription(Prescription Prescription);
    List<Prescription> getAllPrescriptions();
    Prescription getPrescriptionById(long idPrescription);
    void deletePrescription(long idPrescription);
    Prescription updatePrescription(Prescription Prescription);

}
