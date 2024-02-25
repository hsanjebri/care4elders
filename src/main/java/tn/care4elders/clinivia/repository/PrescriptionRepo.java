package tn.care4elders.clinivia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Equipment;
import tn.care4elders.clinivia.entity.Prescription;

@Repository
public interface PrescriptionRepo extends CrudRepository <Prescription, Long>{
}
