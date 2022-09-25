package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> maxSalaryInDepartment(Integer departmentId) {
        return employeeService.maxSalaryInDepartment(departmentId);
    }

    public Optional<Employee> minSalaryInDepartment(Integer departmentId) {
        return employeeService.minSalaryInDepartment(departmentId);
    }

    public String departmentStaff(Integer departmentId) {
        return employeeService.departmentStaff(departmentId);
    }
}
