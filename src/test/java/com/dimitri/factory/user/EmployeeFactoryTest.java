package com.dimitri.factory.user;

import com.dimitri.domain.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {

    private String EmployeeTest;

    @Before
    public void setUp() throws Exception {
        this.EmployeeTest = "EmployeeTest";
    }

    @Test
    public void buildEmployee() {
        Employee employee = EmployeeFactory.buildEmployee("Dimitri", "Ferus");
        System.out.println(employee);
        Assert.assertNotNull(employee.getEmployeeNumber());
    }
}