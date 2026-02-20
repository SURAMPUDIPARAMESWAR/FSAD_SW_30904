package com.klu;

public class Student {
	
	String name;
	String sample;
	int id;
	
	
	public void setName(String name) {
		this.name= name;
	}
	
	public void setSample(String sample) {
		this.sample= sample;
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	public void display() {
		System.out.println("Name of the Student: "+name);
	}

}