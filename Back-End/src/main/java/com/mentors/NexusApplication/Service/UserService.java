package com.mentors.NexusApplication.Service;

import com.mentors.NexusApplication.Exceptions.EmailExistsException;
import com.mentors.NexusApplication.Exceptions.EmailNotFoundException;
import com.mentors.NexusApplication.Exceptions.UserNotFoundException;
import com.mentors.NexusApplication.Exceptions.UsernameExistsException;
import com.mentors.NexusApplication.Model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getUsers();
    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, EmailExistsException, UsernameExistsException, MessagingException;
    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException, UserNotFoundException;
    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException;
    User findUserByUsername(String username);
    User findUserByEmail(String email);

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException;


    Boolean deleteUserById(Long id);
}
