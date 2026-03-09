package com.klu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // Add Course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course saved = service.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get All Courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {

        Optional<Course> course = service.getCourseById(id);

        if(course.isPresent()) {
            return ResponseEntity.ok(course.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    // Update Course
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {

        Optional<Course> existing = service.getCourseById(id);

        if(existing.isPresent()) {
            course.setCourseId(id);
            return ResponseEntity.ok(service.updateCourse(course));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    // Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        Optional<Course> course = service.getCourseById(id);

        if(course.isPresent()) {
            service.deleteCourse(id);
            return ResponseEntity.ok("Course deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    // Search by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {

        List<Course> courses = service.searchByTitle(title);

        if(courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(courses);
    }
}