package com.ms.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ms.app.model.Teacher;

public class MainSpring {
    public static void main(String[] args) {
        //LoadSpringConfiguration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //Retrive Beans
        Teacher pythonteacher=context.getBean("pythonTeacher",Teacher.class);
        Teacher javaTeacher=context.getBean("JavaTeacher",Teacher.class);
        Teacher jvteacher =context.getBean("jvTeacher",Teacher.class);



        //Output Beans
        pythonteacher.outPut();
        javaTeacher.outPut();

        System.out.println(" Id : "+jvteacher.getId()+"\n Name: "+jvteacher.getName()+"\n subject: "+jvteacher.getSubject()+"\n Address: "+jvteacher.getAddress());
        //Close the context
        context.close();


    }
}
