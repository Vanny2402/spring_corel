package com.ms.app.model;

import com.ms.app.services.TeacherService;

public class RusTeacher extends  Teacher{
    //attribute
    TeacherService teacherService;


    public RusTeacher(){};
    public RusTeacher(String name,String subject,String address){
        super(name,subject,address);
    }

    public RusTeacher(TeacherService teacherService){
        this.teacherService=teacherService;

    }

    @Override
    public void outPut() {
        this.teacherService.outPut(this);
    }

    
}
