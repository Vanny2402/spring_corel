package com.ms.app.model;

public abstract  class Teacher {
    //attribut 
    private int id;
    private String name;
    private String subject;
    private String address;

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

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return this.address;
    }
    
    //Constructor 
    public Teacher(){}

    public Teacher(String name,String subject,String address){
        this.id=(int)Math.floor(Math.random()*1000);
        this.name=name;
        this.subject=subject;
        this.address=address;
    }


    //Abanstruct method
    public  abstract void outPut();
}
