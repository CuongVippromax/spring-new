package com.cuongnguyen.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuongnguyen.laptopshop.domain.Role;
import com.cuongnguyen.laptopshop.domain.User;
import com.cuongnguyen.laptopshop.repository.RoleRepository;
import com.cuongnguyen.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersbyEmail(String email) {
        return this.userRepository.findAll();
    }

    public String handleHello() {
        return "Hello from Service";
    }

    public User handleSaveUser(User user) {
        User cuong = this.userRepository.save(user);
        System.out.println(cuong);
        return cuong;
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
