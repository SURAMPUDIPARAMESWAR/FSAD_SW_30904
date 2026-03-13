package com.klu;

public class StudentConstructor {

    private Student student;

    
    public StudentConstructor(Student student) {
        this.student = student;
    }

    public void conDisplay() {
        student.display();
        System.out.println("Constructor Injection Done");
    }
}