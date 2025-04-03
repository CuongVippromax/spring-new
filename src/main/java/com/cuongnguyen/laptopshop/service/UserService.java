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

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public String handleHello() {
        return "Hello from Service";
    }

    public User handleSaveUser(User user) {
        User cuong = this.userRepository.save(user);
        return cuong;
    }

    public User getDetailUser(long id) {
        User detailUser = this.userRepository.findById(id);
        return detailUser;
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public void deleteAUser(long id) {
        this.userRepository.deleteById(id);
    }
}
