package com.Project1.ItlizeGroupProject.Service;

import com.Project1.ItlizeGroupProject.Entity.Project;
import com.Project1.ItlizeGroupProject.Entity.User;
import com.Project1.ItlizeGroupProject.Repository.UserRepository;
import com.Project1.ItlizeGroupProject.TO.ProjectTO;
import com.Project1.ItlizeGroupProject.TO.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean saveUser(UserTO user){
        Date memberSince = new Date(Calendar.getInstance().getTimeInMillis());
        User userEntity = createUserEntity(user);
        userEntity.setMemberSince(memberSince);
        if(repository.save(userEntity) != null)
            return true;
        return false;
    }

    public List<UserTO> getUsers(){
        List<UserTO> listToReturn = new ArrayList<>();
        for (User u: repository.findAll()) {
            u.setPassword(null);
            listToReturn.add(createUserTO(u));
        }
        return listToReturn;
    }

    public UserTO getUserById(int userID){
        return createUserTO(repository.findById(userID).orElse(null));
    }

    public UserTO getByUserName(String userName){
        return createUserTO(repository.findByUserName(userName));
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "User removed: " + id;
    }

    public UserTO updateUser(UserTO user){
        User existingUser = repository.findById(user.getUserID()).orElse(null);
        existingUser.setUserName(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        Set<Project> projects = new HashSet<>();
        for(ProjectTO p: user.getProjects()){
            p.setUser(user);
            projects.add(ProjectService.createProjectEntity(p));
        }
        existingUser.setProjects(projects);
        existingUser = repository.save(existingUser);
        return createUserTO(existingUser);

    }

    public static User createUserEntity(UserTO userTO){
        User userEntity = new User();
        userEntity.setUserID(userTO.getUserID());
        userEntity.setUserName(userTO.getUsername());
        userEntity.setFirstName(userTO.getFirstName());
        userEntity.setLastName(userTO.getLastName());
        userEntity.setEmail(userTO.getEmail());
        userEntity.setPassword(userTO.getPassword());
        //userEntity.setMemberSince(userTO.getMemberSince());
        return userEntity;
    }

    public static UserTO createUserTO(User userEntity){
        UserTO userTO = new UserTO();
        if(userEntity != null) {

            userTO.setEmail(userEntity.getEmail());
            userTO.setUsername(userEntity.getUserName());
            userTO.setFirstName(userEntity.getFirstName());
            userTO.setLastName(userEntity.getLastName());
            Date memberSince = userEntity.getMemberSince();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMMM-dd");
            userTO.setMemberSince(dateFormat.format(memberSince));
            userTO.setPassword(userEntity.getPassword());
            userTO.setUserID(userEntity.getUserID());
            List<ProjectTO> listOfUserProjects = new ArrayList<>();
            for (Project p : userEntity.getProjects()) {
                ProjectTO projectTO = new ProjectTO();
                projectTO.setProjectName(p.getProjectName());
                projectTO.setProjectCode(p.getProjectCode());
                listOfUserProjects.add(projectTO);
            }
            userTO.setProjects(listOfUserProjects);
        }
        return userTO;
    }
}
