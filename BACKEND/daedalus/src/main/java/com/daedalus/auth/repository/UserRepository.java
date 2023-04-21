package com.daedalus.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.auth.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    User findByUsername(String username);
    List<User> findByUsernameContains(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
