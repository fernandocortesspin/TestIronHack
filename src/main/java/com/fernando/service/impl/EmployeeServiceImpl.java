package com.fernando.service.impl;

import com.fernando.entity.Employee;
import com.fernando.repository.EmployeeRepository;
import com.fernando.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String getEmployeeNameById(int id) {
        Employee employee = employeeRepository.getEmployeeNameById(id);

        System.out.println(employee.getId() + " " + employee.getName());

        return employee.getName();
    }

}
