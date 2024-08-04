package pro.sky.courseecmployeecontinuation.service;

import org.springframework.stereotype.Service;
import pro.sky.courseecmployeecontinuation.model.Employee;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeAlreadyAddedException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeNotFoundException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private static final int MAX_EMPLOYEES = 5;
    private final List<Employee> employees = new ArrayList<>(MAX_EMPLOYEES);

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();

    }

    public Collection<Employee> getAll (){
        return Collections.unmodifiableCollection(employees);
    }
}

