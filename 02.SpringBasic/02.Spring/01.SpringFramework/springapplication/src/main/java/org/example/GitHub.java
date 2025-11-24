package org.example;

public class GitHub implements CodeRepo{
    String name;
    public GitHub(){
        this.name="Github";
    }

    @Override
    public String pushCode() {
        return ("Code pushed to "+name);
    }
}


