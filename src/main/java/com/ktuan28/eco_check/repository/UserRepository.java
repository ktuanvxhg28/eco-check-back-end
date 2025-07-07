package com.ktuan28.eco_check.repository;

import com.ktuan28.eco_check.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

}
