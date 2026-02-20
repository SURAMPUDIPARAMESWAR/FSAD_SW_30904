package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConstructor {
	private Student student;
	
	@Autowired
	StudentConstructor(Student student){
		this.student=student;
	}
	public void conDisplay() {
		student.display();
		System.out.println("Constructor Injection done with Annotation....");
	}

}