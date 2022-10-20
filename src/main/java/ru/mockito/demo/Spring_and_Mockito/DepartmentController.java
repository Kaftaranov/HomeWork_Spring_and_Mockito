package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/maxsalary")
    public Optional<Employee> maxSalary(@RequestParam("departmentId") int departmentId) {
        return (departmentService.maxSalaryInDepartment(departmentId));
    }

    @GetMapping("/minsalary")
    public Optional<Employee> minSalary(@RequestParam("departmentId") int departmentId) {
        return (departmentService.minSalaryInDepartment(departmentId));
    }
    @GetMapping("/staff")
    public String departmentStaff(@RequestParam("departmentId") int departmentId){
        return (departmentService.departmentStaff(departmentId));
    }

}
