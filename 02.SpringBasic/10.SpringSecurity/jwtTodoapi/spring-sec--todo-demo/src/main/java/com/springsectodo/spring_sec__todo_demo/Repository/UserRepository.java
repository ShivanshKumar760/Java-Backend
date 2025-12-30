package com.springsectodo.spring_sec__todo_demo.Repository;

import com.springsectodo.spring_sec__todo_demo.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
