package com.ms.app.model;

import com.ms.app.services.TeacherService;


public class JavaTeacher extends Teacher {

    //Attribute
    private TeacherService teacherService;


    public JavaTeacher(TeacherService teacherService){
        this.teacherService=teacherService;

    }

    public JavaTeacher() {
        super();
    }
    public JavaTeacher(String name, String subject,String address) {
        
        super(name,subject,address);

    }
    @Override
    public void outPut() {

        // System.out.print(" I am Java Teacher and Id : "+super.getId()+"\n Name: "+super.getName()+"\n Subject : "+super.getSubject()+"\n Address: "+super.getAddress());
        this.teacherService.outPut(this);
    }
    
}