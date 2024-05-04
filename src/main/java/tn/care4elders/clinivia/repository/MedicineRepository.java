package tn.care4elders.clinivia.repository;

HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Medicine;

public interface MedicineRepository  extends JpaRepository<Medicine,Long> {
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Medicine;
}
@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long> {
}
