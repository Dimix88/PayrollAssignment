package com.dimitri.service;

import com.dimitri.domain.user.Employee;
import com.dimitri.factory.user.EmployeeFactory;
import com.dimitri.repository.user.EmployeeRepository;
import com.dimitri.repository.user.impl.EmployeeRepositoryImpl;
import com.dimitri.service.user.EmployeeService;
import com.dimitri.service.user.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private Employee employee;

    @Before
    public void setUp() throws Exception {
        this.employeeService = EmployeeServiceImpl.getEmployeeService();
        this.employee = EmployeeFactory.buildEmployee("Dimitri", "Ferus");
        this.employeeService.create(employee);
    }


    @Test
    public void a_create() {

        Employee employee2 = EmployeeFactory.buildEmployee("Marky","Mark");
        this.employeeService.create(employee2);
        String name = "Marky";
        Assert.assertEquals(name,employee2.getEmployeeFirstName());
        Assert.assertEquals(employee2,employeeService.read(employee2.getEmployeeNumber()));
        System.out.println(employee2.toString());
    }

    @Test
    public void b_update() {
        String newName = "Mark";
        Employee employeeNew = new Employee.Builder().copy(employee).employeeFirstName(newName).build();
        this.employeeService.update(employeeNew);
        System.out.println("In update, about to be updated = " + employeeNew);
        Assert.assertEquals(employeeNew, this.employeeService.read(employeeNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {
        Employee deleteEmployee = EmployeeFactory.buildEmployee("Ken","King");
        employeeService.delete(deleteEmployee.getEmployeeNumber());
        Employee result = employeeService.read(deleteEmployee.getEmployeeNumber());
        Assert.assertFalse(employeeService.getAll().iterator().next().getEmployeeFirstName().contains("Ken"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {

        Employee read = this.employeeService.read(employee.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getEmployeeNumber(), this.employeeService.read(employee.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.employeeService.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeService.getAll().size());
        Assert.assertEquals(all.size(),employeeService.getAll().size());
    }
}