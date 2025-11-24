package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.beans.ConstructorProperties;

public class Student {
    private int rollNumber;
    private int age;
    private String Name;

    private Laptop laptop;
    private Router router;
    private Editor editor;

    private CodeRepo repo;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {//this method will be called by spring to inject the value
        this.age = age;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {//This will set the laptop using setter injection
        this.laptop = laptop;
    }

    public void setEditor(Editor editor){
        this.editor=editor;
    }

    public void setRepo(CodeRepo repo){
        this.repo=repo;
    }

    public Student(){
        System.out.println("Created");
    }
    @ConstructorProperties({"router"})
    public Student(Router router){
        this.router=router;
    }

    public void code(){
        int id= laptop.laptopid;
        String lapname=laptop.laptopName;
        if(router.connected()){
            System.out.print("Coding....on "+lapname+" model number is"+id+"Connected to router"+editor.usingEditor()+" and "+repo.pushCode());
        }
        else{
            System.out.print("Coding....on "+lapname+" model number is"+id);
        }


    }
}
