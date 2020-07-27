package com.Project1.ItlizeGroupProject.Controller;

import com.Project1.ItlizeGroupProject.Entity.User;
import com.Project1.ItlizeGroupProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/userByID/{userID}")
    public User findUserById(@PathVariable int userID){
        return service.getUserById(userID);
    }

    @GetMapping("/user/{userName}")
    public User findUserByName(@PathVariable String userName){
        return service.getUserByName(userName);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }




}
