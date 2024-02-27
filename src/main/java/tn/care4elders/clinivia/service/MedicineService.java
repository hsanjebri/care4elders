package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine addMedicine(Medicine Medicine);
    List<Medicine> getAllMedicines();
    Medicine getMedicineById(long idMedicine);
    void deleteMedicine(long idMedicine);
    Medicine updateMedicine(Medicine Medicine);

}
