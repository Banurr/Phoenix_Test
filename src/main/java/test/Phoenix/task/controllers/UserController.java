package test.Phoenix.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Phoenix.task.dtos.UserCreate;
import test.Phoenix.task.exceptions.PasswordsNotMatchException;
import test.Phoenix.task.exceptions.UserAlreadyExistsException;
import test.Phoenix.task.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserCreate userCreate)
    {
        try
        {
            userService.addUser(userCreate);
            return ResponseEntity.ok("User registered successfully");
        }
        catch (UserAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("User with this email already exists");
        }
        catch (PasswordsNotMatchException e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Passwords doesn't match");
        }
    }
}
