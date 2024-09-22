package pro.sky.courseecmployeecontinuation.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.courseecmployeecontinuation.exeptions.ValidationException;
import pro.sky.courseecmployeecontinuation.model.Employee;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeAlreadyAddedException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeNotFoundException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private static final int MAX_EMPLOYEES = 10;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Alexiev", 1, 45000),
            new Employee("Alexei", "Ivanov", 2, 60000),
            new Employee("Igor", "Nicolaev", 3, 48000),
            new Employee("Michail", "Boyarsky", 3, 54000),
            new Employee("Dmitry", "Kharatyan", 4, 46000),
            new Employee("Marlyn", "Makarov", 4, 52000),
            new Employee("Gogi", "Kaladje", 5, 47000),
            new Employee("Monya", "Shneerzon", 5, 51000)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentID, int salary) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        validateYes(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentID, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        validateYes(firstName, lastName);
        boolean employeeRemoved = employees.removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));
        if (employeeRemoved) {
            return "Сотрудник " + firstName + " " + lastName + " удален";
        }
        return "Сотрудник " + firstName + " " + lastName + " не найден";
    }

    public Employee findEmployee(String firstName, String lastName) {
        validateYes(firstName, lastName);
        return employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> allEmployees() {
        return employees;
    }

    private void validateYes(String value1, String value2) {
        if (!(StringUtils.isAlpha(value1) && StringUtils.isAlpha(value2))) {
            throw new ValidationException();
        }
    }
}






