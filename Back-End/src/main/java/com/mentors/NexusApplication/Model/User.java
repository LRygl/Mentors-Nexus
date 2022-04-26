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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String[] getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(String[] userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(Date userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }

    public Date getUserLastLoginDateDisplay() {
        return userLastLoginDateDisplay;
    }

    public void setUserLastLoginDateDisplay(Date userLastLoginDateDisplay) {
        this.userLastLoginDateDisplay = userLastLoginDateDisplay;
    }

    public Date getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(Date userJoinDate) {
        this.userJoinDate = userJoinDate;
    }

    public Date getUserLastUpdatedDate() {
        return userLastUpdatedDate;
    }

    public void setUserLastUpdatedDate(Date userLastUpdatedDate) {
        this.userLastUpdatedDate = userLastUpdatedDate;
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

    public User(Long id, String userFirstName, String userLastName, String username, String userPassword, String userEmail, String userCompany, String userProfileImageUrl, String userRole, String[] userAuthorities, Date userLastLoginDate, Date userLastLoginDateDisplay, Date userJoinDate, Date userLastUpdatedDate, Boolean isActive, Boolean isNotLocked) {
        this.id = id;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
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
}
