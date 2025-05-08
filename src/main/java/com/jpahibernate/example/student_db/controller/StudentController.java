package com.jpahibernate.example.student_db.controller;

import com.jpahibernate.example.student_db.model.Student;
import com.jpahibernate.example.student_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController  {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student s){
        System.out.println("Received: " + s);
        return studentService.addStudent(s);
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping("/find/{studentId}")
    public Student getByStudentId(@PathVariable int studentId){
        return studentService.getById(studentId);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteById(@PathVariable int studentId){
        return studentService.deleteById(studentId);
    }

    @PutMapping("/update/{studentId}")
    public String updateThroughPut(@PathVariable int studentId, @RequestBody Student student){
        return studentService.updateThroughPut(studentId, student);
    }

    @PatchMapping("/update/{studentId}")
    public String updateThroughPatch(@PathVariable int studentId, @RequestParam String grade){
        return studentService.updateThroughPatch(studentId, grade);
    }
}
