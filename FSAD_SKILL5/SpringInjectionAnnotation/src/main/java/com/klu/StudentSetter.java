package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentSetter {

    private Student student;

    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDisplay() {
        student.display();
        System.out.println("Setter injection through Annotation....");
    }
}