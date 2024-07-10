package com.ms.app.model;


public class JavaTeacher extends Teacher {


    public JavaTeacher() {
        super();
    }
    public JavaTeacher(String name, String subject) {
        
        super(name,subject);
    }

    @Override
    public void outPut() {

        System.out.print(" I am Java Teacher and Id : "+super.getId()+"\n Name: "+super.getName()+"\n Subject : "+super.getSubject());
    }
    
}