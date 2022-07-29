package com.example.libr.core.Services;

import com.example.libr.core.model.tabeluser.Role;
import com.example.libr.core.model.tabeluser.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User getEmail(String email);
    List<User>getUsers();
}
