package ru.mockito.demo.Spring_and_Mockito;

import java.util.Objects;

public class Employee {
    private int id;
    private final String name;
    private final String middlename;
    private final String surname;
    private final double salary;
    private final int departmentId;

    public Employee(String name, String middlename, String surname, int departmentId, Double salary, int id)
    {   this.name = name;
        this.middlename = middlename;
        this.surname = surname;
        this.departmentId = departmentId;
        this.salary = salary;
        this.id = id;
    }
    public  String getName() {return name;}
    public String getMiddlename(){return middlename;}
    public  String getSurname() {return surname;}
    public int getId(){return id;}

    public Double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Double setSalary(double salary) {
        return salary;
    }

    @Override
    public String toString(){
        return ("ID " + id + ", "+ name + " " + " " + middlename + " " + surname + ", " + "salary - " + salary);
    }

    @Override
    public boolean equals(Object tocompare){
        if (this.getClass()!= tocompare.getClass()){
            return false;
        }
        Employee e = (Employee) tocompare;
        return (name.equals(e.name)&&surname.equals(e.surname));
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, surname);
    }
}