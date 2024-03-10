package tn.care4elders.clinivia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Schedule;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Long> {
}
