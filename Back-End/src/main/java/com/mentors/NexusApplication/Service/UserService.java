package com.mentors.NexusApplication.Service;

import com.mentors.NexusApplication.Exceptions.*;
import com.mentors.NexusApplication.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, EmailExistsException, UsernameExistsException, MessagingException;
    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException, UserNotFoundException;
    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException;
    User findUserByUsername(String username);
    User findUserByEmail(String email);

    void resetUserPassword(String email, String username) throws MessagingException, EmailNotFoundException, PasswordResetException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException;


    Boolean deleteUserById(Long id);

    Page<User> getUserPaginationAndSorting(Integer page, Integer pageSize,String sortDirection, String sortBy);
}
