package com.klu;

public class StudentConstructor {
	private Student student;
	StudentConstructor(Student student){
		this.student=student;
	}
	public void conDisplay() {
		student.display();
		System.out.println("Constructor Injection done....");
	}

}