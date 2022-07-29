package com.example.libr.core.Services;

import com.example.libr.core.model.tabeluser.Role;
import com.example.libr.core.model.tabeluser.User;
import com.example.libr.core.repo.RoleRepo;
import com.example.libr.core.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService { // implementasi UserService

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //get by email

        User user = userRepo.findByEmail(email); // mencari by email

        if (user == null)
        {
            log.error("User tidak ditemukan!");
            throw new UsernameNotFoundException("User tidak ditemukan!");
        } else
        {
            log.error("User by email {} ditemukan!", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {

        log.info("Menyimpan Data User by Email {} ke Database", user.getNama());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {

        log.info("Menyimpan Jenis {} Role ke Database", role.getRole());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {

        log.info("Menambahkan Role {} ke User by Email {}", roleName, email);
        User user = userRepo.findByEmail(email);
        Role role = roleRepo.findByRole(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getEmail(String email) {
        log.info("Mengambil Data User by Email {} ", email);
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        log.info("Mengambil Semua Data User ");
        return userRepo.findAll();
    }


}
