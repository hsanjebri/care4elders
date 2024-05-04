package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
HEAD
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Department;

@Repository
import tn.care4elders.clinivia.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
