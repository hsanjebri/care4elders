package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IserviceUser {
    User addUser (User user);
    User updateUser(User user);
    void deleteUser(Long idUser);
    Optional<User> getUserById(Long idUser);
    List<User> getAllUsers();
}
