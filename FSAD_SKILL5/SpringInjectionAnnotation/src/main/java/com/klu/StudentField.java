package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentField {

    @Autowired
    private Certification certification;

    public void displayField() {
        System.out.println("Field Injection Successful");
        System.out.println(certification);
    }
}