package com.example.libr.core.repo;

import com.example.libr.core.model.tabeluser.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);


}
