package com.learning.microservices.studentservice.Repository;

import com.learning.microservices.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
