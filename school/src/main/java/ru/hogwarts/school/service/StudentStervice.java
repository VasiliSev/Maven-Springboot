package ru.hogwarts.school.service;

import ru.hogwarts.school.models.Student;

import java.util.Collection;

public interface StudentStervice {

    Student addStudent (Student student);
    Student findStudet (long id);
    Student editStudent (Student student);
    Collection<Student> findByAge(int age);
    Student deleteStudent (long id);
}
