package ru.mockito.demo.Spring_and_Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringAndMockitoApplicationTests {
    private final String ALL_STAFF = "All staff";
    private final Integer ID = 5;
    private final Integer WRONG_ID = 20;
    private final String NOT_FOUND = "Employee with Id " + WRONG_ID + " not found.";
    private final String AFONYA = "Afanasiy Nikolaevich Borshchyov";
    private final String MIN_SALARY = "1000";
    private final String MAX_SALARY = "1111";

private final EmployeeService employeeServiceMock = mock(EmployeeService.class);
@InjectMocks
private EmployeeService OUT;

@Test
    public void shouldReturnNotFound(){
    when(employeeServiceMock.find(WRONG_ID)).thenReturn(NOT_FOUND);
    Assertions.assertEquals(OUT.find(WRONG_ID),NOT_FOUND);
}
@Test
    public void shouldReturnBorshchyov(){
    when(employeeServiceMock.find(ID)).thenReturn(AFONYA);
    Assertions.assertEquals(OUT.find(ID),AFONYA);
}
@Test
    public void shouldReturnAllStaff() {
    when(employeeServiceMock.allStaff()).thenReturn(ALL_STAFF);
    Assertions.assertEquals(OUT.allStaff().toString(), ALL_STAFF);
}
@Test
    public void shouldReturnMinSalaryInDepartment(){
    when(employeeServiceMock.minSalaryInDepartment(ID).toString()).thenReturn(MIN_SALARY);
    Assertions.assertEquals(OUT.minSalaryInDepartment(ID).toString(),MIN_SALARY);
}
@Test
    public void shouldReturnMaxSalaryInDepartment(){
    when(employeeServiceMock.maxSalaryInDepartment(ID).toString()).thenReturn(MAX_SALARY);
    Assertions.assertEquals(OUT.maxSalaryInDepartment(ID).toString(),MAX_SALARY);
}
@Test
    public void shouldReturnDepartmentStaff(){
    when(employeeServiceMock.departmentStaff(ID)).thenReturn(AFONYA);
    Assertions.assertEquals(OUT.departmentStaff(ID),AFONYA);
}
    }
