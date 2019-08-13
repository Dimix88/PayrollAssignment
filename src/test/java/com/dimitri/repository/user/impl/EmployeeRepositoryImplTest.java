package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.Employee;
import com.dimitri.factory.user.EmployeeFactory;
import com.dimitri.repository.user.EmployeeRepository;
import com.dimitri.repository.user.impl.EmployeeRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private EmployeeRepository employeeRepository;
    private Employee employee;
    private Set<Employee>employees;

    @Before
    public void setUp() throws Exception {
        this.employeeRepository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Dimitri", "Ferus");
        this.employees = new HashSet<>();
        this.employeeRepository.create(employee);
    }


    @Test
    public void a_create() {
        /*Employee created = this.employeeRepository.create(this.employee);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);*/

        String name = "Dimitri";
        Assert.assertEquals(1, this.employeeRepository.getAll().size());
        Assert.assertEquals(name,employee.getEmployeeFirstName());
        Assert.assertNotNull(employees);
        System.out.println(employee.toString());
    }

    @Test
    public void b_update() {
        String newName = "Mark";
        Employee employeeNew = new Employee.Builder().copy(employee).employeeFirstName(newName).build();
        this.employeeRepository.create(employeeNew);
        System.out.println("In update, about to be updated = " + employeeNew);
        employees.add(this.employeeRepository.update(employeeNew));
        Assert.assertEquals(employeeNew, this.employeeRepository.read(employeeNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {

        this.employeeRepository.delete(employee.getEmployeeNumber());
        System.out.println(employees);
    }

    @Test
    public void c_read() {

        System.out.println("In read, courseId = "+ employee.getEmployeeNumber());
        Employee read = this.employeeRepository.read(employee.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(employee.getEmployeeNumber(), this.employeeRepository.read(employee.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.employeeRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeRepository.getAll().size());
    }
}