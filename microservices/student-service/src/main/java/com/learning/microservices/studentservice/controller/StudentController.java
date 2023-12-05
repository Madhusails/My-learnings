package com.learning.microservices.studentservice.controller;

import com.learning.microservices.studentservice.DTO.StudentDto;
import com.learning.microservices.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<StudentDto> GetAll()
    {
        return studentService.findAllStudents();
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") int id)
    {
        StudentDto studentDto=studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentDto);
    }
}
