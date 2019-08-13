package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.Employee;
import com.dimitri.repository.user.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepository employeeRepository = null;

    private Set<Employee>employees;


    private EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getRepository(){
        if (employeeRepository == null) employeeRepository = new EmployeeRepositoryImpl();
        return employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        //Employee em = new Employee.Builder().copy(employee).employeeFirstName(); #Due to using SET this is not needed
        Employee toDelete = search(employee.getEmployeeNumber());
        if (toDelete != null){
            employees.remove(toDelete);
            return create(employee);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Employee toDelete = search(s);
        if (toDelete != null) {
            this.employees.remove(toDelete);
        }
    }

    @Override
    public Employee read(final String s) {
        return search(s);
    }

    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }

    private Employee search(String id){
        for(Employee employeeSearch:this.employees){
            if(employeeSearch.getEmployeeNumber().equals(id))
                return employeeSearch;
        }
        return null;
    }
}
