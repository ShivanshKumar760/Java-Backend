package org.example;



public class CodeEditor implements Editor {
    String name="notepad";

    @Override
    public String usingEditor() {
        return ("Using "+name+" as Editor");
    }
}


class VsCode implements Editor {
    String name;

    public VsCode() {
        this.name = "VS Code";   // Changing the editor name
    }

    @Override
    public String usingEditor() {
        return ("Using "+name+" as Editor");
    }
}
