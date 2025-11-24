package com.example.understandingDI;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CodeEditor {
    String name="notepad";
    public String usingEditor(){
        return name;
    }
}

@Component
class VsCode extends CodeEditor {

    public VsCode() {
        this.name = "VS Code";   // Changing the editor name
    }

    @Override
    public String usingEditor() {
        return name;
    }
}
