package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
}
