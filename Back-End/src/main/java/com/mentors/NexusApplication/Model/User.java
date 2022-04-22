package com.mentors.NexusApplication.Model;

import java.util.Date;


public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String profileImageUrl;
    private String role;
    private String company;
    private String[] authorities;

    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private Date updatedDate;

    private Boolean isActive;
    private Boolean isNotLocked;
}
