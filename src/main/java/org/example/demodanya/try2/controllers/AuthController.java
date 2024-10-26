package org.example.demodanya.try2.controllers;


import org.example.demodanya.try2.models.Users;
import org.example.demodanya.try2.models.UserLoginDto;
import org.example.demodanya.try2.models.UserRegistrationDto;
import org.example.demodanya.try2.repository.UserRepository;
import org.example.demodanya.try2.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationDto registrationDto) {
        Users user = new Users();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(registrationDto.getRole());
        userRepository.save(user);
        return "User registered successfully";
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
        return authentication.getPrincipal().toString();
    }

    @GetMapping("/admin")
    public String admin (Authentication authentication) {
        return authentication.getPrincipal().toString();
    }


//    @PostMapping("/login")
//    public String login(@RequestBody UserLoginDto loginDto) {
//        Users existingUser = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
//        if (existingUser != null && passwordEncoder.matches(loginDto.getPassword(), existingUser.getPassword())) {
//            return jwtUtil.generateToken(existingUser.getUsername(), existingUser.getRole());
//        } else {
//            throw new RuntimeException("Invalid username or password");
//        }
//    }
}
