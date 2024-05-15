package com.fernando;

import com.fernando.repository.EmployeeRepository;
import com.fernando.service.EmployeeService;
import com.fernando.service.impl.EmployeeServiceImpl;

public class Main {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepository());
        System.out.println(employeeService.getEmployeeNameById(1));
    }

}
