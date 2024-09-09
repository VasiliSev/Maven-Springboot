package pro.sky.courseecmployeecontinuation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseecmployeecontinuation.model.Employee;
import pro.sky.courseecmployeecontinuation.service.DepartmentService;
import pro.sky.courseecmployeecontinuation.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService service;
    public final DepartmentService deptService;

    public EmployeeController(EmployeeService service, DepartmentService deptService) {
        this.service = service;
        this.deptService = deptService;
    }


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentNumber, @RequestParam int salary) {
        service.addEmployee(firstName, lastName, departmentNumber, salary);
        return new Employee(firstName, lastName, departmentNumber, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        service.removeEmployee(firstName, lastName);
        return ("Сотрудник" + firstName + lastName + "удален");
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Employee> allEmployees() {
        return service.allEmployees();
    }

    @GetMapping("/departments/max-salary")
    public Employee maxSalaryInDept(@RequestParam int departmentID) {
        return deptService.maxSalaryInDept(departmentID);
    }

    @GetMapping("/departments/mix-salary")
    public Employee mixSalaryInDept(@RequestParam int departmentID) {
        return deptService.minSalaryInDept(departmentID);

    }

    @GetMapping("department/all")
    public List<Employee> allInDepartment(@RequestParam int departmentID) {
        return deptService.allInDepartment(departmentID);
    }

    @GetMapping("department/all")
    public Map<Integer, List<Employee>> allDepartments(){
        return deptService.allDepartments();
    }
}

