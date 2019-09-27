package com.training.jpacode.controller;

import com.training.jpacode.domain.Student;
import com.training.jpacode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    private List<Student> findStudents(@RequestParam(required = false) Integer id) {
        if(id == null) {
            return studentService.findAllStudents();
        }else {
            return Collections.singletonList(studentService.getStudentById(id));
        }
    }

    @GetMapping("/{id}")
    private Student findStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void enterNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        if(id == null) throw new RuntimeException("ID needed to update student");

        Student currentStudent = studentService.getStudentById(id);
        if(currentStudent == null) throw new IndexOutOfBoundsException("Student database not found");

        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());
        currentStudent.setAge(student.getAge());

        studentService.saveStudent(currentStudent);
    }
}
