package com.mentors.NexusApplication.Resource;

import com.mentors.NexusApplication.Exceptions.EmailExistsException;
import com.mentors.NexusApplication.Exceptions.EmailNotFoundException;
import com.mentors.NexusApplication.Exceptions.UserNotFoundException;
import com.mentors.NexusApplication.Exceptions.UsernameExistsException;
import com.mentors.NexusApplication.Model.HttpResponse;
import com.mentors.NexusApplication.Model.User;
import com.mentors.NexusApplication.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = {"/","/user"})
public class UserResource {
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestParam("firstName") String firstName,
                                           @RequestParam("lastName") String lastName,
                                           @RequestParam("username") String username,
                                           @RequestParam("email") String email,
                                           @RequestParam("role") String role,
                                           @RequestParam("isActive") String isActive,
                                           @RequestParam("isNonLocked") String isNonLocked,
                                           @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException, EmailNotFoundException {
        User newUser = userService.addNewUser(firstName, lastName, username, email, role, Boolean.parseBoolean(isActive) ,Boolean.parseBoolean(isNonLocked), profileImage);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestParam("currentUsername") String currentUsername,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("username") String username,
                                       @RequestParam("email") String email,
                                       @RequestParam("role") String role,
                                       @RequestParam("isActive") String isActive,
                                       @RequestParam("isNonLocked") String isNonLocked,
                                       @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws UserNotFoundException, EmailExistsException, UsernameExistsException, IOException, EmailNotFoundException {
        User updateUser = userService.updateUser(currentUsername, firstName, lastName, username, email, role, Boolean.parseBoolean(isActive) ,Boolean.parseBoolean(isNonLocked), profileImage);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .httpStatusCode(HttpStatus.OK.value())
                        .httpTimestamp(new Date(System.currentTimeMillis()))
                        .httpResponseData(Map.of("Deleted",userService.deleteUserById(id)))
                        .httpStatusMessage("User deleted " + id)
                        .httpDeveloperMessage("Oops")
                        .httpStatusReason("test")
                        .build()
        );
    }
}
