package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Users;
import org.example.demodanya.try2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users myUser = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return User.builder().username(myUser.getUsername()).password(myUser.getPassword()).roles(myUser.getRole()).build();
    }
}
