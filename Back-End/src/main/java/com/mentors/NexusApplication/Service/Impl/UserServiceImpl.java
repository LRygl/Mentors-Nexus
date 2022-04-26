package com.mentors.NexusApplication.Service.Impl;

import com.mentors.NexusApplication.Exceptions.EmailExistsException;
import com.mentors.NexusApplication.Exceptions.UserNotFoundException;
import com.mentors.NexusApplication.Exceptions.UsernameExistsException;
import com.mentors.NexusApplication.Model.User;
import com.mentors.NexusApplication.Repository.UserRepository;
import com.mentors.NexusApplication.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.mentors.NexusApplication.Constants.UserImplementationConstant.*;

@Service
@Qualifier("UserDetailService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email){
        return userRepository.findUserByUserEmail(email);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        userRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException {
        validateNewUsernameAndEmail(StringUtils.EMPTY, username, email);
        User user = new User();
        String password = generateUserPassword();
        //String encodedPassword = encodePassword(password);
        //user.setUserId(generateUserId());
        user.setUserFirstName(firstName);
        user.setUserLastName(lastName);
        user.setUserJoinDate(new Date());
        user.setUsername(username);
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setActive(isActive);
        user.setNotLocked(isNonLocked);
        //user.setRole(getRoleEnumName(role).name());
        //user.setAuthorities(getRoleEnumName(role).getAuthorities());
        //   user.setProfileImageUrl(getTemporaryProfileImageUrl(username));
        userRepository.save(user);
        //saveProfileImage(user, profileImage);
        return user;
    }

    @Override
    public User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException {
        User currentUser = validateNewUsernameAndEmail(currentUsername, newUsername, newEmail);
        currentUser.setUserFirstName(newFirstName);
        currentUser.setUserLastName(newLastName);
        currentUser.setUsername(newUsername);
        currentUser.setUserEmail(newEmail);
        currentUser.setActive(isActive);
        currentUser.setNotLocked(isNonLocked);
        //currentUser.setRole(getRoleEnumName(role).name());
        //currentUser.setAuthorities(getRoleEnumName(role).getAuthorities());
        userRepository.save(currentUser);
        //saveProfileImage(currentUser, profileImage);
        return currentUser;
    }



    private User validateNewUsernameAndEmail(String currentUserName, String newUserName, String userEmail) throws EmailExistsException, UsernameExistsException, UserNotFoundException {
        User userByNewUsername = findUserByUsername(newUserName);
        User userByNewEmail = findUserByEmail(userEmail);

        if(StringUtils.isNotBlank(currentUserName)) {
            //User with username does not exist
            User currentUser = findUserByUsername(currentUserName);
            if (currentUser == null){
                throw new UserNotFoundException(NO_USER_FOUND_BY_USERNAME + currentUserName);
            }
            if (userByNewUsername != null && !currentUser.getId().equals(userByNewUsername.getId())) {
                throw new UsernameExistsException(USERNAME_ALREADY_EXIST);
            }
            if (userByNewEmail != null && !currentUser.getId().equals(userByNewEmail.getId())) {
                throw new EmailExistsException(EMAIL_ALREADY_EXIST);
            }
            return currentUser;
        } else {
            if (userByNewUsername != null){
                throw new UsernameExistsException(USERNAME_ALREADY_EXIST);
            }
            if (userByNewEmail != null) {
                throw new EmailExistsException(EMAIL_ALREADY_EXIST);
            }
            return null;
        }
    }

    private String generateUserPassword(){
        return RandomStringUtils.randomAlphanumeric(10);
    }



}
