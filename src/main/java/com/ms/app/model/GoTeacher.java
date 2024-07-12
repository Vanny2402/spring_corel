package com.ms.app.model;

import com.ms.app.services.TeacherService;

public class GoTeacher extends  Teacher{
    //attribute
    TeacherService teacherService;


    public GoTeacher(){};
    public GoTeacher(String name,String subject,String address){
        super(name,subject,address);
    }

    public GoTeacher(TeacherService teacherService){
        this.teacherService=teacherService;

    }

    @Override
    public void outPut() {
        this.teacherService.outPut(this);
    }
}
