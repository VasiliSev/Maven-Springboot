package pro.sky.courseecmployeecontinuation.service;

import pro.sky.courseecmployeecontinuation.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Employee maxSalaryInDept (int departmentID);
    Employee minSalaryInDept (int departmentID);
    List<Employee> allInDepartment (int departmentID);
    Map<Integer, List<Employee>> allDepartments();

}
