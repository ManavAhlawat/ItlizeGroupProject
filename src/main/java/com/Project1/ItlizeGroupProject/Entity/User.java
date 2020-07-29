package com.Project1.ItlizeGroupProject.Entity;



import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    public User(){

    }

    //primary key
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="userID")
    private int userID;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="MemberSince")
    private Date memberSince;

    @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "UserProject_FK", referencedColumnName = "userID")
    private List<Project> projects;



    public User(String userName, String password, String firstName, String lastName, String email, Date memberSince, List<Project> projects) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.memberSince = memberSince;
        this.projects = projects;
    }

//    public <E> User(String userName, String password, ArrayList<E> es) {
//    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public List<Project> getProjects() {
            List<Project> listToReturn = new ArrayList<>();
            for (Project p: projects) {
                p.setUser(null);
                listToReturn.add(p);
            }
        return listToReturn;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
