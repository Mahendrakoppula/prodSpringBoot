package com.cors.cors.Repository;

import com.cors.cors.Entity.Student;
import com.cors.cors.ResponseMessage.StudentsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public StudentsResponse getAllStudents() {
        StudentsResponse response = new StudentsResponse();

        if (students.size() == 0) {
            response.setMessage("No students found");
        } else {
            response.setMessage("Students details retrieved");
            response.setStudents(students);
        }

        return response;
    }
    public StudentsResponse createStudent(Student student) {
        StudentsResponse response = new StudentsResponse();

        student.setId(nextId);
        nextId++;
        students.add(student);
        response.setMessage("Student created successfully");
        response.setStudents(Collections.singletonList(student));

        return response;
    }

    public StudentsResponse getStudentById(Long id) {
        StudentsResponse response = new StudentsResponse();

        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        if (student.isPresent()) {
            response.setStudents(Collections.singletonList(student.get()));
            response.setMessage("Student details retrieved");
        } else {
            response.setMessage("Student not found");
        }

        return response;
    }

    public StudentsResponse deleteStudent(Long id) {
        StudentsResponse response = new StudentsResponse();

        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (removed) {
            response.setMessage("Student deleted successfully");
        } else {
            response.setMessage("Student not found");
        }

        return response;
    }
}
