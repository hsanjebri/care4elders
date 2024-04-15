package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Patient;

import java.util.Optional;


public interface PatientRepository extends JpaRepository <Patient,Long>{
    Patient findByAddress(String email);
}
