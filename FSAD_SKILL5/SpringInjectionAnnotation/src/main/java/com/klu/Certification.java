package com.klu;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 501;
    private String name = "Spring Framework Certification";
    private String dateOfCompletion = "2026-03-15";

    public void displayCertification() {
        System.out.println("Certification ID : " + id);
        System.out.println("Certification Name : " + name);
        System.out.println("Completion Date : " + dateOfCompletion);
    }

    public String toString() {
        return "Certification ID : " + id +
               "\nCertification Name : " + name +
               "\nCompletion Date : " + dateOfCompletion;
    }
}