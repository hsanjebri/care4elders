package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.VitalSign;

public interface VitalSignRepository extends JpaRepository<VitalSign,Long> {
}
