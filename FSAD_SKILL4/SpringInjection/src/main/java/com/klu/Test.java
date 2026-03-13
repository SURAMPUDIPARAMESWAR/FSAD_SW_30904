package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        Student st = ctx.getBean(Student.class);
        st.display();

        StudentSetter stusett =
            (StudentSetter) ctx.getBean("studentsetter");
        stusett.setDisplay();

        StudentConstructor stcon =
            (StudentConstructor) ctx.getBean("studentconstructor");
        stcon.conDisplay();
        
    }
}