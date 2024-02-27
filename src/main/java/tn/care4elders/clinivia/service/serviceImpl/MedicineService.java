package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.repository.MedicineRepository;


import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicineService implements tn.care4elders.clinivia.service.MedicineService {

    MedicineRepository medicineRepo  ;

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return (Medicine) medicineRepo.save(medicine);
    }
    @Override
    public List<Medicine> getAllMedicines() {
        return (List<Medicine>) medicineRepo.findAll();
    }
    @Override
    public Medicine getMedicineById(long idMedicine) {
        return (Medicine) medicineRepo.findById(idMedicine).get();
    }
    @Override
    public void deleteMedicine(long idMedicine) {
        medicineRepo.deleteById(idMedicine);
    }
    @Override
    public Medicine updateMedicine(Medicine medicine) {
        return (Medicine) medicineRepo.save(medicine);
    }

}
