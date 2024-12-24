package ru.hogwarts.school.service;

import ru.hogwarts.school.models.Faculty;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Optional;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(long id);
}
