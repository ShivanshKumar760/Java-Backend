package com.springsectodo.spring_sec__todo_demo.Repository;

import com.springsectodo.spring_sec__todo_demo.TodoEntity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserUsername(String username);
}