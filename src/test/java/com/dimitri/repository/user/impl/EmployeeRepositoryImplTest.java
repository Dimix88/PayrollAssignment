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
        employees.add(employeeRepository.create(employee));
    }


    @Test
    public void a_create() {

        Employee employee2 = EmployeeFactory.buildEmployee("Marky","Mark");
        employees.add(employeeRepository.create(employee2));
        String name = "Marky";
        Assert.assertEquals(2, this.employeeRepository.getAll().size());
        Assert.assertEquals(name,employee2.getEmployeeFirstName());
        Assert.assertNotNull(employees);
        Assert.assertEquals(employee2,employeeRepository.read(employee2.getEmployeeNumber()));
        System.out.println(employee2.toString());
    }

    @Test
    public void b_update() {
        String newName = "Mark";
        Employee employeeNew = new Employee.Builder().copy(employee).employeeFirstName(newName).build();
        employees.add(this.employeeRepository.update(employeeNew));
        System.out.println("In update, about to be updated = " + employeeNew);
        Assert.assertEquals(employeeNew, this.employeeRepository.read(employeeNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {
        Employee deleteEmployee = EmployeeFactory.buildEmployee("Ken","King");
        employees.add(employeeRepository.create(deleteEmployee));
        employees.remove(deleteEmployee);
        employeeRepository.delete(deleteEmployee.getEmployeeNumber());
        Employee result = employeeRepository.read(deleteEmployee.getEmployeeNumber());
        System.out.println(employees);
        Assert.assertFalse(employeeRepository.getAll().iterator().next().getEmployeeFirstName().contains("Ken"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {

        Employee read = this.employeeRepository.read(employee.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getEmployeeNumber(), this.employeeRepository.read(employee.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.employeeRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeRepository.getAll().size());
        Assert.assertEquals(all.size(),employeeRepository.getAll().size());
    }
}