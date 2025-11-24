package com.example.understandingDI;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Setter
    @Getter
    private int age;
    @Getter
    @Setter
    private int rollNum;
    @Getter
    @Setter
    private String Name;
    @Autowired
    private Laptop lap;//field injection
    private Router router;
    public  Student(Router router){//constructor injection
        this.router=router;
    }

    private CodeEditor editor;

    @Autowired
    public void setEditor(CodeEditor editor) {//setter injection
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", rollNum=" + rollNum +
                ", Name='" + Name + '\'' +
                '}';
    }

    public void code(){
        int id=lap.laptopid;
        String lapname=lap.laptopName;
        if(router.connected()){
            System.out.print("Coding....on "+lapname+" model number is"+id+"Connected to router"+" using "+editor.usingEditor());
        }
        else{
            System.out.print("Coding....on "+lapname+" model number is"+id);
        }

    }
}
