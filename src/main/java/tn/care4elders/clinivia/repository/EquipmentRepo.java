package tn.care4elders.clinivia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Equipment;

@Repository
public interface EquipmentRepo extends CrudRepository<Equipment, Long> {
}
