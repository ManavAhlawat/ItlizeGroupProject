package com.Project1.ItlizeGroupProject.Repository;


import com.Project1.ItlizeGroupProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

    //User deleteByUserID(Integer integer);

}
