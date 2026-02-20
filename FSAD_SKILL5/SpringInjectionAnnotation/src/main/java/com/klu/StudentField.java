package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentField {
	
	@Autowired
	private Student student;
	public void fieldDisplay() {
		student.display();
		System.out.println("Field Injection done with Annotation....");
	}
	

}