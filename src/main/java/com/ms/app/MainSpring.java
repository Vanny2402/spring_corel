package com.ms.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ms.app.model.Teacher;

public class MainSpring {
    public static void main(String[] args) {
        //LoadSpringConfiguration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //Retrive Beans
        Teacher javaTeacher=context.getBean("JavaTeacher",Teacher.class);
        //Output Beans
        javaTeacher.outPut();
        //Close the context
        context.close();

    }
}
