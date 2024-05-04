package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {


}
