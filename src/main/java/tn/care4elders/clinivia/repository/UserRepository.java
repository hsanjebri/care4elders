package tn.care4elders.clinivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.care4elders.clinivia.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
}
