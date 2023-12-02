package com.cors.cors.Controller;

import com.cors.cors.Entity.Student;
import com.cors.cors.Repository.StudentService;
import com.cors.cors.ResponseMessage.StudentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public StudentsResponse getAllStudents() {
        return studentService.getAllStudents();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
//        Optional<Student> student = studentService.getStudentById(id);
//        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping
    public StudentsResponse createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentsResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public StudentsResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
//        Student result = studentService.updateStudent(id, updatedStudent);
//        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }
}
