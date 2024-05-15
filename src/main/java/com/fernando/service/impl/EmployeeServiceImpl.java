package com.fernando.service.impl;

import com.fernando.repository.EmployeeRepository;
import com.fernando.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String getEmployeeNameById(int id) {

        return employeeRepository.getEmployeeNameById(id).getName();
    }

}
