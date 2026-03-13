package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentSetter {

    private Certification certification;

    @Autowired
    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public void displaySetter() {
        System.out.println("Setter Injection Successful");
        System.out.println(certification);
    }
}