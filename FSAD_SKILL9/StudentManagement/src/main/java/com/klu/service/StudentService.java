package com.klu.service;

import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;
import com.klu.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(int id){

        if(id <= 0){
            throw new InvalidInputException("Student ID must be positive");
        }

        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID "+id+" not found"));
    }
}