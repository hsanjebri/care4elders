package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Iervice;

@Repository
public interface IerviceRepository extends JpaRepository<Iervice,Long> {
}
