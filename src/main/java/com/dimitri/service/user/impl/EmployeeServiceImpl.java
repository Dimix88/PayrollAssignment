package com.dimitri.service.user.impl;

import com.dimitri.domain.user.Employee;
import com.dimitri.repository.user.EmployeeRepository;
import com.dimitri.repository.user.impl.EmployeeRepositoryImpl;
import com.dimitri.service.user.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService service = null;
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl(){
        this.employeeRepository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeService getEmployeeService(){
        if (service == null) service = new EmployeeServiceImpl();
        return service;
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.delete(s);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }

    /*@Override
    public Employee saveEmployee(String firstName, String lastName, String gender){
        Employee e = EmployeeFactory.buildEmployee(firstName, lastName);
        //get gender if exist

        create(e);
        return e;
    }*/

    @Override
    public Set<Employee>getAll() {
        return this.employeeRepository.getAll();
    }
}
