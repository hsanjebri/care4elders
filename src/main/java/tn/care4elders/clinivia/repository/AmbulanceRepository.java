package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Ambulance;

public interface AmbulanceRepository extends JpaRepository<Ambulance,Long> {
}
