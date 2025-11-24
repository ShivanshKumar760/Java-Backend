package org.example;

public class GitLab implements CodeRepo{
    String name;
    public GitLab(){
        this.name="Gitlab";
    }

    @Override
    public String pushCode() {
        return ("Code pushed to "+name);
    }
}
