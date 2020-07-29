package com.Project1.ItlizeGroupProject.Service;

import com.Project1.ItlizeGroupProject.Entity.User;
import com.Project1.ItlizeGroupProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int userID){
        return repository.findById(userID).orElse(null);
    }

    public User getUserByName(String name){
        return repository.findByUserName(name).orElse(null);
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "User removed: " + id;
    }

    public User updateUser(User user){
        User existingUser = repository.findById(user.getUserID()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setMemberSince(user.getMemberSince());
        return repository.save(existingUser);

    }

}
