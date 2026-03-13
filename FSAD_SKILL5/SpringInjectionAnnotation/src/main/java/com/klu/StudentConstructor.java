package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConstructor {

    private Certification certification;

    @Autowired
    public StudentConstructor(Certification certification) {
        this.certification = certification;
    }

    public void displayConstructor() {
        System.out.println("Constructor Injection Successful");
        System.out.println(certification);
    }
}