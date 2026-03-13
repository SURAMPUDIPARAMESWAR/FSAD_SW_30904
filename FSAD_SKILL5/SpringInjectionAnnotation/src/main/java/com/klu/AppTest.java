package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("----- Student Bean -----");
        Student st = ctx.getBean(Student.class);
        st.display();

        System.out.println("\n----- Field Injection -----");
        StudentField sf = ctx.getBean(StudentField.class);
        sf.displayField();

        System.out.println("\n----- Setter Injection -----");
        StudentSetter ss = ctx.getBean(StudentSetter.class);
        ss.displaySetter();

        System.out.println("\n----- Constructor Injection -----");
        StudentConstructor sc = ctx.getBean(StudentConstructor.class);
        sc.displayConstructor();
    }
}