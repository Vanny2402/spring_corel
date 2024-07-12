package com.ms.app.services.serviceimpliment;

import com.ms.app.model.Teacher;
import com.ms.app.services.TeacherService;

public class TeacherServiceIml implements TeacherService {

    @Override
    public void outPut(Teacher teacher) {
        System.out.print(" I am Teacher and Id : "+teacher.getId()+"\n Name: "+teacher.getName()+"\n Subject : "+teacher.getSubject()+"\n Address: "+teacher.getAddress()+"\n\n");
    }
}
