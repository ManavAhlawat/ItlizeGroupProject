package com.Project1.ItlizeGroupProject.Controller;

import com.Project1.ItlizeGroupProject.Service.UserService;
import com.Project1.ItlizeGroupProject.TO.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//    @PostMapping("/register")
//    public Boolean register(@RequestBody String json) throws JSONException {
//        JSONObject jsonObj = new JSONObject(json);
//        String username = jsonObj.getString("username");
//        String password = jsonObj.getString("password");
//        String first = jsonObj.getString("first_name");
//        String last = jsonObj.getString("last_name");
//        String email = jsonObj.getString("email");
//        User newUser = new User(username, password, first, last, email, new Date(), new HashSet<Project>());
//        User created = service.saveUser(newUser);
//        return (created != null) ? true : false;
//    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserTO user){
        if(user.getUsername().equals(service.getUserByName(user.getUsername()))){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        user.setMemberSince(Calendar.getInstance().getTime());
        //System.out.println(user);
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.CREATED);
    }


//    @PostMapping("/addUser")
//    public User addUser(@RequestBody User user){
//        return service.saveUser(user);
//    }

    @GetMapping("/users")
    public List<UserTO> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/userByID/{userID}")
    public UserTO findUserById(@PathVariable int userID){
        return service.getUserById(userID);
    }

    @GetMapping("/user/{userName}")
    public UserTO findUserByName(@PathVariable String userName){
        return service.getUserByName(userName);
    }

    @PutMapping("/updateUser")
    public UserTO updateUser(@RequestBody UserTO user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(service.deleteUser(id));
//        return service.deleteUser(id);
    }
}