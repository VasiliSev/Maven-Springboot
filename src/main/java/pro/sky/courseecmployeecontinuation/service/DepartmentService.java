package pro.sky.courseecmployeecontinuation.service;

import org.springframework.stereotype.Service;
import pro.sky.courseecmployeecontinuation.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee maxSalaryInDept(int departmentID) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentID == employee.getDepartmentID())
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }

    @Override
    public Employee minSalaryInDept(int departmentID) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentID == employee.getDepartmentID())
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public int getSalaryInDept(int departmentID) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentID == employee.getDepartmentID())
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public List<Employee> allInDepartment(int departmentID) {
        return employeeService.allEmployees()
                .stream()
                .filter(employee -> departmentID == employee.getDepartmentID())
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> allDepartments() {
        return employeeService.allEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }
}
