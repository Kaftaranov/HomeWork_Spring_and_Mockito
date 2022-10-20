package ru.mockito.demo.Spring_and_Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;
import static org.mockito.Mockito.when;

//@SpringBootTest - препятствует нормальному тестированию с использованием Mockito
@ExtendWith(MockitoExtension.class)
class SpringAndMockitoApplicationTests {
    private final Integer ID = 1;
    private final Integer WRONG_ID = 20;
    private final String NOT_FOUND = "Employee with Id " + WRONG_ID + " not found.";
    private final Double MIN_SALARY = 5000D;
    private final Double MAX_SALARY = 12000D;
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentService OUT;
    private Stream<Employee> testStream;
    @BeforeEach
    private void streamIni() {
         testStream = Stream.of(
                new Employee("Semyon", "Semyonovich", "Gorbunkov", 1, 5000D, 1),
                new Employee("Fyodor", "Mikhailovich", "Sukhov", 1, 7000D, 2),
                new Employee("Pavel", "Artemyevich", "Vereshchagin", 2, 10000D, 3),
                new Employee("Max", "Otto", "von Schtirlitz", 2, 12000D, 4),
                new Employee("Afanasiy", "Nikolaevich", "Borshchyov", 3, 3000D, 5)
        );
    }

    @Test
    public void shouldReturnMinSalaryInDepartment(){
        when(employeeServiceMock.allStaff())
                .thenReturn(testStream.toList());
        Assertions.assertTrue(OUT.minSalaryInDepartment(ID).isPresent());
        Assertions.assertEquals(OUT.minSalaryInDepartment(ID).get().getSalary(),MIN_SALARY);
    }

    @Test
    public void shouldReturnMaxSalaryInDepartment(){
        when(employeeServiceMock.allStaff())
                .thenReturn(testStream.toList());
    Assertions.assertTrue(OUT.maxSalaryInDepartment(ID).isPresent());
    Assertions.assertEquals(OUT.maxSalaryInDepartment(ID).get().getSalary(),7000);
}
    @Test
    public void shouldReturnDepartmentStaff(){
        List<Employee> localList = testStream.toList();
        when(employeeServiceMock.allStaff()).thenReturn(localList);
        Assertions.assertEquals( OUT.departmentStaff(3) , "[" +localList.get(4).toString()+ "]");
    }

}
