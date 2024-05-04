package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Medicine;

public interface MedicineRepository  extends JpaRepository<Medicine,Long> {
}
