package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Equipment;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    @Query("SELECT i FROM Equipment i WHERE i.category = :category")
    List<Equipment> findEquipmentByCategory(String category);
    @Query("SELECT DISTINCT e.category FROM Equipment e order by e.category ASC")
    List<String> findAllCategories();

}
