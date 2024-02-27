package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.care4elders.clinivia.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository <Complaint,Long> {
}
