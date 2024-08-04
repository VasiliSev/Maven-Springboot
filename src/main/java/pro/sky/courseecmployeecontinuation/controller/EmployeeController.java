package pro.sky.courseecmployeecontinuation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseecmployeecontinuation.model.Employee;
import pro.sky.courseecmployeecontinuation.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        service.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return service.getAll();
    }
}
