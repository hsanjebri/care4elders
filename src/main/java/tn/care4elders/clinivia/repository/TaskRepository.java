package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.care4elders.clinivia.entity.Task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {



    @Query("SELECT t FROM Task t WHERE t.due_date BETWEEN :startDate AND :endDate AND t.done = false")
    List<Task> findByDueDateBetweenAndDoneFalse(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    // New query to find tasks by patient ID
    @Query("SELECT t FROM Task t WHERE t.patient.IdPatient = :patientId")
    List<Task> findTasksByPatientId(@Param("patientId") long patientId);
}
