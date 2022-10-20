package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> minSalaryInDepartment(Integer departmentId) {
        return employeeService.allStaff().stream()
                .filter(d -> Objects.equals(d.getDepartmentId(), departmentId))
                .min(Comparator.comparingDouble(Employee::getSalary));
    }
    public Optional<Employee> maxSalaryInDepartment(Integer departmentId) {
        return employeeService.allStaff().stream()
                .filter(d -> Objects.equals(d.getDepartmentId(), departmentId))
                .max(Comparator.comparingDouble(Employee::getSalary));
    }
    public String departmentStaff(Integer departmentId) {
        return employeeService.allStaff().stream()
                .filter(d -> Objects.equals(d.getDepartmentId(), departmentId)).toList()
                .toString();
    }
}
