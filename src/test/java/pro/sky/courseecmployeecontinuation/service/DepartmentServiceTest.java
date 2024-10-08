package pro.sky.courseecmployeecontinuation.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseecmployeecontinuation.model.Employee;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Ivan", "Alexiev", 1, 45000),
                new Employee("Alexei", "Ivanov", 2, 60000),
                new Employee("Igor", "Nicolaev", 3, 48000),
                new Employee("Michail", "Boyarsky", 3, 54000),
                new Employee("Dmitry", "Kharatyan", 4, 46000),
                new Employee("Marlyn", "Makarov", 4, 52000),
                new Employee("Gogi", "Kaladje", 5, 47000),
                new Employee("Monya", "Shneerzon", 5, 51000)
        ));
        when(employeeService.allEmployees()).thenReturn(employees);
    }

    @Test
    void maxSalaryInDeptTest() {
        assertEquals(new Employee("Michail", "Boyarsky", 3, 54000), departmentService.maxSalaryInDept(3));
        assertNull(departmentService.maxSalaryInDept(-1));
    }

    @Test
    void minSalaryInDeptTest() {
        assertEquals(new Employee("Igor", "Nicolaev", 3, 48000), departmentService.minSalaryInDept(3));
        assertNull(departmentService.maxSalaryInDept(-1));
    }

    @Test
    void getSalaryInDeptTest() {
        assertEquals(102000, departmentService.getSalaryInDept(3));
    }

    @Test
    void allDepartmentTest() {
        assertThat(departmentService.allInDepartment(3)).containsExactly(
                new Employee("Igor", "Nicolaev", 3, 48000),
                new Employee("Michail", "Boyarsky", 3, 54000)
        );
        assertThat(departmentService.allInDepartment(5)).containsExactly(
                new Employee("Gogi", "Kaladje", 5, 47000),
                new Employee("Monya", "Shneerzon", 5, 51000)
        );
        assertThat(departmentService.allInDepartment(1)).containsExactly(
                new Employee("Ivan", "Alexiev", 1, 45000)
        );
    }

    @Test
    void allDepartmentsTest() {
        Map<Integer, List<Employee>> fact = departmentService.allDepartments();

        assertThat(fact).isEqualTo(
                Map.of(1, List.of(
                                new Employee("Ivan", "Alexiev", 1, 45000)
                        ),
                        2, List.of(
                                new Employee("Alexei", "Ivanov", 2, 60000)
                        ),
                        3, List.of(
                                new Employee("Igor", "Nicolaev", 3, 48000),
                                new Employee("Michail", "Boyarsky", 3, 54000)
                        ),
                        4, List.of(
                                new Employee("Dmitry", "Kharatyan", 4, 46000),
                                new Employee("Marlyn", "Makarov", 4, 52000)
                        ),
                        5, List.of(
                                new Employee("Gogi", "Kaladje", 5, 47000),
                                new Employee("Monya", "Shneerzon", 5, 51000)
                        )
                )
        );
    }
}
