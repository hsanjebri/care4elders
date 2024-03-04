package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.Funeral;

import java.util.Optional;

public interface FuneralRepository extends JpaRepository<Funeral,Long> {
}
