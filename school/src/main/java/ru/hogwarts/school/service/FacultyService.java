package ru.hogwarts.school.service;

import ru.hogwarts.school.models.Faculty;

import java.security.SecureRandom;
import java.util.Collection;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Collection<Faculty> findByColour(String colour);

    Faculty editFaculty(Faculty faculty);

    Faculty deleteFaculty(long id);
}