package com.cuongnguyen.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuongnguyen.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User cuong);

    void deleteById(long id);

    List<User> findByEmail(String email);

    User findById(long id);

    User getUserById(long id);
}
