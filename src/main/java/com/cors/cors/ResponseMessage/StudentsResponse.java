package com.cors.cors.ResponseMessage;

import com.cors.cors.Entity.Student;

import java.util.List;

public class StudentsResponse {
    private List<Student> students;
    private String message;

    public StudentsResponse(List<Student> students, String message) {
        this.students = students;
        this.message = message;
    }

    public StudentsResponse() {

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
