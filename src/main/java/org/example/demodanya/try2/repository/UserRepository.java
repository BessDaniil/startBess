package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);
}
