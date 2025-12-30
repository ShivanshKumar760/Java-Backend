package com.springsectodo.spring_sec__todo_demo.DTO;

import com.springsectodo.spring_sec__todo_demo.UserEntity.User;

public class TodoRequestDTO {

    private String todo;
    private String description;
    //getter
    public String getTodo(){
        return  this.todo;
    }
    public String getDescription(){
        return this.description;
    }
    //setter
    public void setTodo(String todo){
        this.todo=todo;
    }
    public void setDescription(String desc){
        this.description=desc;
    }


}
