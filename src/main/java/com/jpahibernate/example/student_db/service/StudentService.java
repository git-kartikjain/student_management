package com.jpahibernate.example.student_db.service;

import com.jpahibernate.example.student_db.model.Student;
import com.jpahibernate.example.student_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student s){
        studentRepository.save(s);
        return "Student saved";
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getById(int studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.get();
    }

    public String deleteById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student with id " + studentId + " got deleted";
    }

    public String updateThroughPut(int studentId, Student newStudent){
        Student student1 = getById(studentId);
        if(student1 != null){
            studentRepository.save(newStudent);
            return "Student update through put done";
        }
        return "Student not found, can't update";
    }

    public String updateThroughPatch(int studentId, String grade){
        Student student1 = getById(studentId);
        if(student1 != null){
            student1.setGrade(grade);
            studentRepository.save(student1);
            return "Student update through patch done";
        }
        return "Student not found, can't update";
    }
}
