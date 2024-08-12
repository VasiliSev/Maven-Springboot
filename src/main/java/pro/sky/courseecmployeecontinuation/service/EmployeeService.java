package pro.sky.courseecmployeecontinuation.service;

import org.springframework.stereotype.Service;
import pro.sky.courseecmployeecontinuation.model.Employee;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeAlreadyAddedException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeNotFoundException;
import pro.sky.courseecmployeecontinuation.exeptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {

    private static final int MAX_EMPLOYEES = 10;
    private final Map<String, Employee> employees = new HashMap<>(MAX_EMPLOYEES);

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }


    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(employee.getFullName());
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

