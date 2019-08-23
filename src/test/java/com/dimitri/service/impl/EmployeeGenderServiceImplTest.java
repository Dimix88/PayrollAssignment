package com.dimitri.service.impl;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.factory.user.EmployeeGenderFactory;
import com.dimitri.repository.user.EmployeeGenderRepository;
import com.dimitri.repository.user.impl.EmployeeGenderRepositoryImpl;
import com.dimitri.service.user.EmployeeGenderService;
import com.dimitri.service.user.impl.EmployeeGenderServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGenderServiceImplTest {

    private EmployeeGenderService employeeGenderService;
    private EmployeeGender employeeGender;


    @Before
    public void setUp() throws Exception {
        this.employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
        this.employeeGender = EmployeeGenderFactory.buildEmployeeGender("111","222");
        this.employeeGenderService.create(employeeGender);
    }


    @Test
    public void a_create() {
        EmployeeGender employeeGender2 = EmployeeGenderFactory.buildEmployeeGender("333","444");
        this.employeeGenderService.create(employeeGender2);
        String newNumber = employeeGender2.getEmployeeNumber();
        Assert.assertEquals(newNumber,employeeGender2.getEmployeeNumber());
        Assert.assertEquals(employeeGender2,this.employeeGenderService.read(employeeGender2.getEmployeeNumber()));
        System.out.println(employeeGender.toString());
    }

    @Test
    public void b_update() {
        String newNumber = "211114";
        EmployeeGender employeeGenderNew = new EmployeeGender.Builder().copy(employeeGender).genderId(newNumber).build();
        this.employeeGenderService.update(employeeGenderNew);
        System.out.println("In update, about to be updated = " + employeeGenderNew);
        Assert.assertEquals(employeeGenderNew, this.employeeGenderService.read(employeeGenderNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {
        EmployeeGender deleteEmployeeGender = EmployeeGenderFactory.buildEmployeeGender("999","555");
        this.employeeGenderService.create(deleteEmployeeGender);
        this.employeeGenderService.delete(deleteEmployeeGender.getEmployeeNumber());
        EmployeeGender result = employeeGenderService.read(deleteEmployeeGender.getEmployeeNumber());
        Assert.assertFalse(this.employeeGenderService.getAll().iterator().next().getEmployeeNumber().contains("999"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {
        EmployeeGender read = this.employeeGenderService.read(employeeGender.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getEmployeeNumber(), this.employeeGenderService.read(read.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender> all = this.employeeGenderService.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeGenderService.getAll().size());
    }
}