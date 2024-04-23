package test.Phoenix.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import test.Phoenix.task.dtos.UserCreate;
import test.Phoenix.task.dtos.UserView;
import test.Phoenix.task.exceptions.PasswordsNotMatchException;
import test.Phoenix.task.exceptions.UserAlreadyExistsException;
import test.Phoenix.task.mappers.UserMapper;
import test.Phoenix.task.repositories.UserRepository;

import java.time.LocalDateTime;

public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserCreate userCreate) throws UserAlreadyExistsException, PasswordsNotMatchException
    {
        var user = loadUserByUsername(userCreate.getEmail());
        if (user != null) throw new UserAlreadyExistsException("User with this email already exists!");
        if (!userCreate.getPassword().equals(userCreate.getRePassword())) throw new PasswordsNotMatchException("Passwords doesn't match!");
        var newUser = UserMapper.INSTANCE.toEntity(userCreate);
        newUser.setPassword(passwordEncoder.encode(userCreate.getPassword()));
        newUser.setCreated_at(LocalDateTime.now());
        userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        return userRepository.findByEmail(email);
    }
}
