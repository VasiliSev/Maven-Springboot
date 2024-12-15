package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.service.StudentStervice;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentStervice studentStervice;

    public StudentController(StudentStervice studentStervice) {
        this.studentStervice = studentStervice;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student student = studentStervice.findStudet(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent (@RequestBody Student student){
        return studentStervice.addStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentStervice.editStudent(student);
        if (foundStudent == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student);
    }
    @DeleteMapping ("{id}")
    public ResponseEntity<Void> deleteStudent (@PathVariable long id) {
        studentStervice.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}