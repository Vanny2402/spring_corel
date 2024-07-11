package com.ms.app.model;

import com.ms.app.services.TeacherService;

public class PythonTeacher extends Teacher{

    //attribut
    private TeacherService teacherService;

    public void setTeacherService(TeacherService _teacherService) {
        this.teacherService = _teacherService;
    }
    @Override
    public void outPut() {
        teacherService.outPut(this);

    }

}
