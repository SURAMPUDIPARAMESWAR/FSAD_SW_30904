package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student st = ctx.getBean(Student.class);
        st.display();

        StudentSetter ss = ctx.getBean(StudentSetter.class);
        ss.setDisplay();

        StudentConstructor sc = ctx.getBean(StudentConstructor.class);
        sc.conDisplay();

        StudentField sf = ctx.getBean(StudentField.class);
        sf.fieldDisplay();
    }
    
}