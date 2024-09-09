package pro.sky.courseecmployeecontinuation.service;

import pro.sky.courseecmployeecontinuation.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee addEmployee(String firstName, String lastName, int departmentID, int salary);
    String removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> allEmployees();
}
