package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeGender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderFactoryTest {

    @Test
    public void buildEmployeeGender() {
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender("11","33");
        String empNr = "11";
        System.out.println(employeeGender);
        Assert.assertEquals(empNr,employeeGender.getEmployeeNumber());
        Assert.assertNotNull(employeeGender);
    }
}