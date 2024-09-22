package pro.sky.courseecmployeecontinuation.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseecmployeecontinuation.exeptions.ValidationException;
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


    public EmployeeController(EmployeeService service) {
        this.service = service;

    }


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentID, @RequestParam int salary) {
        return service.addEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), departmentID, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
                return service.removeEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return service.findEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }

    @GetMapping("/all")
    public List<Employee> allEmployees() {
        return service.allEmployees();
    }



}

