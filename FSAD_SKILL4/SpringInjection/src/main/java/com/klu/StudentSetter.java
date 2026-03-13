package com.klu;

public class StudentSetter {

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDisplay() {
        student.display();
        System.out.println("Setter Injection Done");
    }
}