# Mentors Nexus

## Application Overview
Application allows users to 

### Features
* Register
* Login
* Reset Password
* Enroll to course
* Watch course
* Finish Course
* Pay for Course
* 
## Architecture Overview

### test
- Use pP
- x
- s


# Installation
`mvn clean install`

```Java
 public void addUserToLoginAttemptCache(String username) {
        int attempts = 0;
        try {
            attempts = ATTEMPT_INCREMENT + loginAttemptCache.get(username);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        loginAttemptCache.put(username, attempts);
    }
```
# AWS
## EC2
## Load Balancing
# Payment Gateway