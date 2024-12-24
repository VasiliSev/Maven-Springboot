package ru.hogwarts.school.service;

import ru.hogwarts.school.models.Student;

import java.util.Collection;

public interface StudentService {
    Student addStudent(Student student);
    Student findStudent(long id);
    Student editStudent(Student student);
    Collection<Student> getAll();
    void deleteStudent(long id);
}
