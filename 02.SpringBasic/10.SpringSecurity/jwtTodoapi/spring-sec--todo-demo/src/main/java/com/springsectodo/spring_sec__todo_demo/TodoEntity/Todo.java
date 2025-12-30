package com.springsectodo.spring_sec__todo_demo.TodoEntity;

import com.springsectodo.spring_sec__todo_demo.UserEntity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "Todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todo;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)   // important
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //getter
    public Long getId(){
        return this.id;
    }
    public String getTodo(){
        return  this.todo;
    }

    public String getDescription(){
        return this.description;
    }
    //setter

    public  void setId(Long id){
        this.id=id;
    }
    public void setTodo(String todo){
        this.todo=todo;
    }

    public void setDescription(String desc){
        this.description=desc;
    }


    public User getUser() { return this.user; }
    public void setUser(User user) { this.user = user; }


}
