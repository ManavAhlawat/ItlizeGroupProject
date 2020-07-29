package com.Project1.ItlizeGroupProject.Entity;



import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

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
    private Set<Project> projects;

    public User(){

    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", memberSince=" + memberSince +
                '}';
    }

    public User(String userName, String password, String firstName, String lastName, String email, Date memberSince, Set<Project> projects) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.memberSince = memberSince;
        this.projects = projects;
    }

//    public <E> User(String manav, String $2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6, ArrayList<E> es) {
//    }

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

    public Set<Project> getProjects() {
            Set<Project> setToReturn = new HashSet<>();
            for (Project p: projects) {
                p.setUser(null);
                setToReturn.add(p);
            }
        return setToReturn;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
