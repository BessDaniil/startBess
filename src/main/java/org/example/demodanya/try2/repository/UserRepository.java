package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional <Users> findByUsername(String username);
    boolean existsByUsername(String username);
}
