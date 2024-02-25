package tn.care4elders.clinivia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Equipment;
import tn.care4elders.clinivia.entity.Medicine;

@Repository
public interface MedicineRepo extends CrudRepository<Medicine, Long> {
}
