package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.User;

import java.util.List;


public interface IserviceUser {
    User addUser (User user);
    User updateUser(User user);
    void deleteUser(Long idUser);
    //edited by shadha
    User getUserById(Long idUser);
    List<User> getAllUsers();
    boolean EmailUnique(String email);
}
