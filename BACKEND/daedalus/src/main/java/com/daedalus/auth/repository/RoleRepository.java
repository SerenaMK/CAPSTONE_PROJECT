package com.daedalus.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.auth.entity.ERole;
import com.daedalus.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
