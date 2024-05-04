package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}
