package pro.sky.courseecmployeecontinuation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseecmployeecontinuation.model.Employee;
import pro.sky.courseecmployeecontinuation.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController (DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryInDept (@RequestParam int departmentID) {
        return service.maxSalaryInDept(departmentID);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryInDept (@RequestParam int departmentID) {
        return service.minSalaryInDept(departmentID);

    }

    @GetMapping("salary/sum")
    public int getSalaryInDept (@RequestParam int departmentID) {
        return service.getSalaryInDept(departmentID);
    }

    @GetMapping("/all-in-dept")
    public List<Employee> allInDepartment (@RequestParam int departmentID) {
        return service.allInDepartment(departmentID);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allDepartments() {
        return service.allDepartments();
    }
}
