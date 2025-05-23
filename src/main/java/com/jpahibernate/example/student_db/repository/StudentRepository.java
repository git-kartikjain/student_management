package com.jpahibernate.example.student_db.repository;

import com.jpahibernate.example.student_db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
