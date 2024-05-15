package com.fernando.repository;

import com.fernando.entity.Employee;

import java.util.Arrays;
import java.util.stream.Stream;

public class EmployeeRepository {

    Stream<Employee> employeeStream;

    public EmployeeRepository(){
        generateEmployee();
    }

    private void generateEmployee(){

        Employee a = new Employee("John Lennon", 1);
        Employee b = new Employee("Paul Mccartney", 2);

        Employee[] employees = {a, b};

        employeeStream = Arrays.stream(employees);
    }

    public Employee getEmployeeNameById(Integer id){

        return employeeStream.filter(employee -> employee.getId().equals(id))
                .findFirst().orElseGet(null);

    }


}
