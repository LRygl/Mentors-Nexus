package com.mentors.NexusApplication.Model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="application_users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String userFirstName;
    private String userLastName;
    private String username;
    private String userPassword;
    private String userEmail;
    private String userCompany;
    private String userProfileImageUrl;
    private String userRole;
    private String[] userAuthorities;

    private Date userLastLoginDate;
    private Date userLastLoginDateDisplay;
    private Date userJoinDate;
    private Date userLastUpdatedDate;

    private Boolean isActive;
    private Boolean isNotLocked;

    public User() {
    }

    public User(Long id, String userFirstName, String lastName, String username, String userPassword, String userEmail, String userCompany, String userProfileImageUrl, String userRole, String[] userAuthorities, Date userLastLoginDate, Date userLastLoginDateDisplay, Date userJoinDate, Date userLastUpdatedDate, Boolean isActive, Boolean isNotLocked) {
        this.id = id;
        this.userFirstName = userFirstName;
        this.userLastName = lastName;
        this.username = username;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userCompany = userCompany;
        this.userProfileImageUrl = userProfileImageUrl;
        this.userRole = userRole;
        this.userAuthorities = userAuthorities;
        this.userLastLoginDate = userLastLoginDate;
        this.userLastLoginDateDisplay = userLastLoginDateDisplay;
        this.userJoinDate = userJoinDate;
        this.userLastUpdatedDate = userLastUpdatedDate;
        this.isActive = isActive;
        this.isNotLocked = isNotLocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String firstName) {
        this.userFirstName = firstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String lastName) {
        this.userLastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String company) {
        this.userCompany = company;
    }

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    public void setUserProfileImageUrl(String profileImageUrl) {
        this.userProfileImageUrl = profileImageUrl;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String role) {
        this.userRole = role;
    }

    public String[] getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(String[] authorities) {
        this.userAuthorities = authorities;
    }

    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(Date lastLoginDate) {
        this.userLastLoginDate = lastLoginDate;
    }

    public Date getUserLastLoginDateDisplay() {
        return userLastLoginDateDisplay;
    }

    public void setUserLastLoginDateDisplay(Date lastLoginDateDisplay) {
        this.userLastLoginDateDisplay = lastLoginDateDisplay;
    }

    public Date getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(Date joinDate) {
        this.userJoinDate = joinDate;
    }

    public Date getUserLastUpdatedDate() {
        return userLastUpdatedDate;
    }

    public void setUserLastUpdatedDate(Date updatedDate) {
        this.userLastUpdatedDate = updatedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(Boolean notLocked) {
        isNotLocked = notLocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + userFirstName + '\'' +
                ", lastName='" + userLastName + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + userPassword + '\'' +
                ", email='" + userEmail + '\'' +
                ", company='" + userCompany + '\'' +
                ", profileImageUrl='" + userProfileImageUrl + '\'' +
                ", role='" + userRole + '\'' +
                ", authorities=" + Arrays.toString(userAuthorities) +
                ", lastLoginDate=" + userLastLoginDate +
                ", lastLoginDateDisplay=" + userLastLoginDateDisplay +
                ", joinDate=" + userJoinDate +
                ", updatedDate=" + userLastUpdatedDate +
                ", isActive=" + isActive +
                ", isNotLocked=" + isNotLocked +
                '}';
    }
}
