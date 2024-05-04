package tn.care4elders.clinivia.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.User;
import tn.care4elders.clinivia.service.serviceImpl.ServiceUserImpl;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/UserController")
@Tag(name = "Gestion des Users",description = "les apis pour gérer tout les Users")


public class UserController {
    @Autowired
    ServiceUserImpl serviceUser;
    @PostMapping("/addUser")
    User addingUser(@RequestBody User user){
        return serviceUser.addUser(user);
    }
    @PostMapping("/updateUser")
    User updatingUser(@RequestBody User user){
        return serviceUser.updateUser(user);
    }
    @DeleteMapping("/deleteUser/{idUser}")
    void deletingUser(@PathVariable("idUser") Long idUser){
        serviceUser.deleteUser(idUser);
    }
    @GetMapping("/getUserById/{idUser}")
    Optional<User> gettingUserById(@PathVariable("idUser") Long idUser){
        return serviceUser.getUserById(idUser);
    }
    @GetMapping("/getAllUsers")
    List<User> gettingAllUsers(){
        return serviceUser.getAllUsers();
    }
}
