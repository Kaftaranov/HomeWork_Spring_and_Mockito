package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import static ru.mockito.demo.Spring_and_Mockito.SpringAndMockitoApplication.staff;

@Service
public class EmployeeService {
    public Stream<String> allStaff(){
        return staff.stream().map(Employee::toString);
    }

    public Optional<Employee> maxSalaryInDepartment(Integer departmentId) {
        return staff.stream()
                .filter(d -> d.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary));
    }
    public Optional<Employee> minSalaryInDepartment(Integer departmentId) {
        return staff.stream()
                .filter(d -> d.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary));
    }
    public String departmentStaff(Integer departmentId) {
        return staff.stream()
                .filter(d -> d.getDepartmentId() == departmentId).toList()
                .toString();
    }
    public Optional<Employee> maxSalary(){
        return staff.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }
    public Optional<Employee> minSalary(){
        return staff.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
    }
    public String remove(int id){
        for (int i = 0; i < staff.size(); i++) {
           if (staff.get(i).getId() == id){
               return staff.remove(i).toString() + " was removed.";
           }
        }
        return "Employee with Id " + id + " not found.";
    }

    public String find(int id) {
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getId() == id){
                return "Employee " + staff.get(i).toString() + " found.";
            }
        }
        return "Employee with Id " + id + " not found.";
    }
}
