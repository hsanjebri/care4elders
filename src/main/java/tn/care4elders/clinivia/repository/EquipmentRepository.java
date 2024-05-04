package tn.care4elders.clinivia.repository;

HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Equipment;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

}
