package com.ms.app.model;

public abstract  class Teacher {
    //attribut 
    private int id;
    private String name;
    private String subject;

    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id = id;
    }


    public String getName() {
    	return this.name;
    }
    public void setName(String name) {
    	this.name = name;
    }


    public String getSubject() {
    	return this.subject;
    }
    public void setSubject(String subject) {
    	this.subject = subject;
    }

    
    //Constructor 
    public Teacher(){}

    public Teacher(String name,String subject){
        this.id=(int)Math.floor(Math.random()*1000);
        this.name=name;
        this.subject=subject;
    }

    //Abanstruct method
    public  abstract void outPut();
}
