package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Prescription;

import java.util.List;

@Repository
public interface PrescriptionRepository extends CrudRepository <Prescription, Long>{



    @Query("SELECT p FROM Prescription p WHERE p.patient.IdPatient = :patientId and p.approved = true ")
    List<Prescription> findByPatientId(@Param("patientId") Long patientId);
    @Query("SELECT p FROM Prescription p WHERE p.doctor.IdUser = :doctorId")
    List<Prescription> findByDoctorId(@Param("doctorId") Long doctorId);


    List<Prescription> findAllByApprovedFalse();
}
