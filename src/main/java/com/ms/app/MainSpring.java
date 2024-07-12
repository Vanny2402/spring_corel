package com.ms.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ms.app.model.Teacher;

public class MainSpring {
    public static void main(String[] args) {
        //LoadSpringConfiguration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //Retrive Beans
        Teacher rusTeacher=context.getBean("rusTeacher",Teacher.class);
        Teacher rusTeacher2=context.getBean("rusTeacher",Teacher.class);// this both are singleton

        Teacher goTeacher=context.getBean("goTeacher",Teacher.class);
        Teacher goTeacher2=context.getBean("goTeacher",Teacher.class);// this both are prototype



        Teacher gpTeacher=context.getBean("goTeacher",Teacher.class);


        goTeacher.setId(1009);
        goTeacher.setName("KOK TOLA");
        goTeacher.setSubject("Go"); 
        goTeacher.setAddress("PPPP");

        

        //Output Beans
        goTeacher.outPut();
        goTeacher2.outPut();// The second instant will null all
        //Close the context
        context.close();
        }
}
