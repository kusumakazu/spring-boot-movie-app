package com.example.libr.core.repo;

import com.example.libr.core.model.tabeluser.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
