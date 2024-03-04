package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Patient;


public interface PatientRepository extends JpaRepository <Patient,Long>{
}
