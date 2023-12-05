package com.learning.microservices.studentservice.service;

import com.learning.microservices.studentservice.DTO.AddressDto;
import com.learning.microservices.studentservice.DTO.StudentDto;
import com.learning.microservices.studentservice.Repository.StudentRepository;
import com.learning.microservices.studentservice.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;
    public List<StudentDto> findAllStudents()
    {
        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentDtoList=students.stream().map(s->modelMapper.map(s, StudentDto.class))
                                     .collect(Collectors.toList());
        return studentDtoList;
    }
    public StudentDto getStudentById(int id)
    {
        Student student=studentRepository.findById(id).get();
        StudentDto studentDto=modelMapper.map(student,StudentDto.class);
        AddressDto addressDto=webClient
                .get()
                .uri("/address/"+id)
                .retrieve()
                .bodyToMono(AddressDto.class)
                .block();
        studentDto.setAddressDto(addressDto);
        return  studentDto;
    }
}
