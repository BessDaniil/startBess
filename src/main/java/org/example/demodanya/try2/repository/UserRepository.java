package org.example.demodanya.try2.repository;

import org.example.demodanya.try2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
