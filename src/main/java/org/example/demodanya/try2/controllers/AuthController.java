package org.example.demodanya.try2.controllers;


import org.example.demodanya.try2.models.User;
import org.example.demodanya.try2.models.UserLoginDto;
import org.example.demodanya.try2.models.UserRegistrationDto;
import org.example.demodanya.try2.repository.UserRepository;
import org.example.demodanya.try2.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(registrationDto.getRole());

        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto loginDto) {
        User existingUser = userRepository.findByUsername(loginDto.getUsername());
        if (existingUser != null && passwordEncoder.matches(loginDto.getPassword(), existingUser.getPassword())) {
            return jwtUtil.generateToken(existingUser.getUsername());
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
