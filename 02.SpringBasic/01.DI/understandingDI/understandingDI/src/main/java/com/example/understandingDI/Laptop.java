package com.example.understandingDI;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    int laptopid=109;
    String laptopName="mac";

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopid=" + laptopid +
                ", laptopName='" + laptopName + '\'' +
                '}';
    }
}
