package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentStervice{

    private final HashMap<Long, Student> students = new HashMap<>();
    private int count = 0;

    @Override
    public Student addStudent(Student student) {
        student.setId(count++);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student findStudet(long id) {
        return students.get(id);
    }

    @Override
    public Student editStudent(Student student) {
        if (!students.containsKey(student.getId())){
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()){
            if(student.getAge() == age)
                result.add(student);
        }
        return result;
    }

    @Override
    public Student deleteStudent(long id) {
        return students.remove(id);
    }
}