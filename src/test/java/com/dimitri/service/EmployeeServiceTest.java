package com.dimitri.service;

import com.dimitri.domain.user.Employee;
import com.dimitri.factory.user.EmployeeFactory;
import com.dimitri.repository.user.EmployeeRepository;
import com.dimitri.repository.user.impl.EmployeeRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class EmployeeServiceTest {

    private EmployeeRepository repository;
    private Employee employee;

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Dimitri", "Ferus");
        repository.create(employee);
    }


    @Test
    public void getAll(){
        Set<Employee> employee = this.repository.getAll();
        System.out.println("In getall, all = " + employee.toString());
    }
}