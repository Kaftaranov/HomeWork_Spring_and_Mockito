package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static ru.mockito.demo.Spring_and_Mockito.SpringAndMockitoApplication.staff;

@Service
public class EmployeeService {
    public List<Employee> allStaff(){
        return staff;
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
        for (Employee employee : staff) {
            if (employee.getId() == id) {
                return "Employee " + employee + " found.";
            }
        }
        return "Employee with Id " + id + " not found.";
    }
}
