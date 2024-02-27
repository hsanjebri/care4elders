package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {




}
