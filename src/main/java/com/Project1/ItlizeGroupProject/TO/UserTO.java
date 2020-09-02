package com.Project1.ItlizeGroupProject.TO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTO {
    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String memberSince;
    private List<ProjectTO> projects;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public List<ProjectTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectTO> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "UserTO{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", memberSince=" + memberSince +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTO userTO = (UserTO) o;
        return userID == userTO.userID &&
                username.equals(userTO.username) &&
                password.equals(userTO.password) &&
                firstName.equals(userTO.firstName) &&
                lastName.equals(userTO.lastName) &&
                email.equals(userTO.email) &&
                Objects.equals(projects, userTO.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, password, firstName, lastName, email, memberSince, projects);
    }
}
