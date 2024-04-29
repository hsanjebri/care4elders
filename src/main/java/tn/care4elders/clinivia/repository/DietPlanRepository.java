package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.care4elders.clinivia.entity.DietPlan;

import java.util.List;

public interface DietPlanRepository extends JpaRepository<DietPlan,Long> {

    @Query("SELECT dp FROM DietPlan dp WHERE dp.patient.IdPatient = :patientId")
    List<DietPlan> findByPatientId(@Param("patientId") long patientId);




}
