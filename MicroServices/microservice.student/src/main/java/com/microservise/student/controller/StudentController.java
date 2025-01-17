package com.microservise.student.controller;

import com.microservise.student.entities.Student;
import com.microservise.student.service.IStudentService;
import com.microservise.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity findAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search-my-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));
    }
}
