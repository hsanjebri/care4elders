package tn.care4elders.clinivia.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.User;
import tn.care4elders.clinivia.repository.UserRepository;
import tn.care4elders.clinivia.service.IserviceUser;

import java.util.List;
import java.util.Optional;


@Service

public class ServiceUserImpl implements IserviceUser {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public User getUserById(Long idUser) {
       return (User) userRepository.findById(idUser).get();


    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public boolean EmailUnique(String email) {
        return userRepository.getAllByEmail(email) == null;
    }
}
