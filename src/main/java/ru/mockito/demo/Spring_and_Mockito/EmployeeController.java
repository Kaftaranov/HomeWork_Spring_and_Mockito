package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/maxsalary")
    public Optional<Employee> maxSalary() {
        return (employeeService.maxSalary());
    }

    @GetMapping("/minsalary")
    public Optional<Employee> minSalary() {
        return (employeeService.minSalary());
    }

    public String departmentStaff(Integer departmentId){
        return (employeeService.departmentStaff(departmentId));
    }

    @GetMapping("allstaff")
    public Stream<String> Staff(){
        return (employeeService.allStaff());
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("Id") Integer id){
        return employeeService.remove(id);
    }
    @GetMapping("/find")
    public String findEmployee(@RequestParam("id") Integer id){
        return employeeService.find(id);
    }

}