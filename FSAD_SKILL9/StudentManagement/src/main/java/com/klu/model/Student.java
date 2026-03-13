package com.klu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	@Id
	private int id;
	@Column
	private String name;
	private String course;

}
