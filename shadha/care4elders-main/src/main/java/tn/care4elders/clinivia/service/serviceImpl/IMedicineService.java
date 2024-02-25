package tn.care4elders.clinivia.service.serviceImpl;

import tn.care4elders.clinivia.entity.Equipment;
import tn.care4elders.clinivia.entity.Medicine;

import java.util.List;

public interface IMedicineService {
    Medicine addMedicine(Medicine Medicine);
    List<Medicine> getAllMedicines();
    Medicine getMedicineById(long idMedicine);
    void deleteMedicine(long idMedicine);
    Medicine updateMedicine(Medicine Medicine);

}
