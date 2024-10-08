package pro.sky.courseecmployeecontinuation.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeAlreadyAddedException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeNotFoundException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeStorageIsFullException;
import pro.sky.courseecmployeecontinuation.exeptions.ValidationException;
import pro.sky.courseecmployeecontinuation.model.Employee;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {


    EmployeeService service = new EmployeeService();

//Ввиду наличия в классах статических методов toLowerCase, capitalize и isAlpha
//имена и фамилии должны содержать только буквы, причем начинаться на заглавную, остальные - строчные

    @Test
    void addTest() {
        assertThat(service.allEmployees()).size().isEqualTo(8);
        var emp = service.addEmployee("Testfirst", "Testlast", 1, 45000);
        assertThat(emp.getFirstName()).isEqualTo("Testfirst");
        assertThat(emp.getLastName()).isEqualTo("Testlast");
        assertThat(emp.getDepartmentID()).isEqualTo(1);
        assertThat(emp.getSalary()).isEqualTo(45000);
        assertThat(service.allEmployees()).size().isEqualTo(9);
        assertThat(service.allEmployees()).contains(emp);
    }

    @Test
    void alreadyExistTest() {
        var emp = service.addEmployee("Testfirst", "Testlast", 1, 45000);
        assertNotNull(emp);
        assertThrows(EmployeeAlreadyAddedException.class, () -> service.addEmployee("Testfirst", "Testlast", 1, 45000));
    }

    @Test
    void overloadTest() {
        service.addEmployee("Testfirsta", "Testlasta", 1, 45000);
        service.addEmployee("Testfirstb", "Testlastb", 2, 46000);
        assertThrows(EmployeeStorageIsFullException.class, () -> service.addEmployee("Testfirstс", "Testlastс", 3, 47000));
    }

    @Test
    void findEmployeeTest() {
        service.addEmployee("Testfirst", "Testlast", 1, 45000);
        var found = service.findEmployee("Testfirst", "Testlast");
        assertNotNull(found);
        assertThat(found.getFirstName()).isEqualTo("Testfirst");
        assertThat(found.getLastName()).isEqualTo("Testlast");
        assertThat(found.getDepartmentID()).isEqualTo(1);
        assertThat(found.getSalary()).isEqualTo(45000);
        assertThat(service.allEmployees()).size().isEqualTo(9);
        assertThat(service.allEmployees()).contains(found);
    }

    @Test
    void employeeNotFoundTest() {
        assertThrows(EmployeeNotFoundException.class, () -> service.findEmployee("Noname", "Nosurname"));
    }

    @Test
    void allEmployeesTest() {
        var expected = List.of(
                new Employee("Ivan", "Alexiev", 1, 45000),
                new Employee("Alexei", "Ivanov", 2, 60000),
                new Employee("Igor", "Nicolaev", 3, 48000),
                new Employee("Michail", "Boyarsky", 3, 54000),
                new Employee("Dmitry", "Kharatyan", 4, 46000),
                new Employee("Marlyn", "Makarov", 4, 52000),
                new Employee("Gogi", "Kaladje", 5, 47000),
                new Employee("Monya", "Shneerzon", 5, 51000),
                new Employee("Testfirsta", "Testlasta", 1, 47000),
                new Employee("Testfirstb", "Testlastb", 2, 43000)
        );

        service.addEmployee("Testfirsta", "Testlasta", 1, 47000);
        service.addEmployee("Testfirstb", "Testlastb", 2, 43000);
        assertThat(service.allEmployees()).containsExactlyElementsOf(expected);
    }

    @Test
    void removeEmployeeTest() {
        service.addEmployee("Testfirst", "Testlast", 1, 47000);
        assertThat(service.removeEmployee("Testfirst", "Testlast")).isEqualTo("Сотрудник Testfirst Testlast удален");
        assertThat(service.removeEmployee("Noname", "Nosurname")).isEqualTo("Сотрудник Noname Nosurname не найден");
    }

    @Test
    void validateYesTest() {
        assertThrows(ValidationException.class, () -> service.addEmployee("Test1", "Test_1", 1, 47000));
    }

}