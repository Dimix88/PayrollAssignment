package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.factory.user.EmployeeGenderFactory;
import com.dimitri.repository.user.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGenderRepositoryImplTest {

    private EmployeeGenderRepository employeeGenderRepository;
    private EmployeeGender employeeGender;
    private Set<EmployeeGender> employeeGenders;

    @Before
    public void setUp() throws Exception {
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getRepository();
        this.employeeGender = EmployeeGenderFactory.buildEmployeeGender("84848","885888");
        this.employeeGenders = new HashSet<>();
        employeeGenders.add(this.employeeGenderRepository.create(employeeGender));
    }


    @Test
    public void a_create() {

        EmployeeGender employeeGender2 = EmployeeGenderFactory.buildEmployeeGender("11111","44444");
        String newNumber = employeeGender2.getEmployeeNumber();
        employeeGenders.add(this.employeeGenderRepository.create(employeeGender2));
        Assert.assertEquals(newNumber,employeeGender2.getEmployeeNumber());
        Assert.assertEquals(employeeGender2,employeeGenderRepository.read(employeeGender2.getEmployeeNumber()));
        Assert.assertNotNull(employeeGenders);
        System.out.println(employeeGender2.toString());
    }

    @Test
    public void b_update() {
        String newNumber = "222222";
        EmployeeGender employeeGenderNew = new EmployeeGender.Builder().copy(employeeGender).genderId(newNumber).build();
        System.out.println("In update, about to be updated = " + employeeGenderNew);
        employeeGenders.add(this.employeeGenderRepository.update(employeeGenderNew));
        System.out.println(employeeGenderRepository.read(employeeGenderNew.getEmployeeNumber()));
        Assert.assertEquals(employeeGenderNew, this.employeeGenderRepository.read(employeeGenderNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {
        EmployeeGender deleteEmployeeGender = EmployeeGenderFactory.buildEmployeeGender("555","9797");
        employeeGenders.add(this.employeeGenderRepository.create(deleteEmployeeGender));
        employeeGenders.remove(deleteEmployeeGender);
        this.employeeGenderRepository.delete(deleteEmployeeGender.getEmployeeNumber());
        EmployeeGender result = this.employeeGenderRepository.read(deleteEmployeeGender.getEmployeeNumber());
        System.out.println(employeeGenders);
        Assert.assertFalse(this.employeeGenderRepository.getAll().iterator().next().getEmployeeNumber().contains("555"));
    }

    @Test
    public void c_read() {
        EmployeeGender read = this.employeeGenderRepository.read(employeeGender.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getEmployeeNumber(), this.employeeGenderRepository.read(employeeGender.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender> all = this.employeeGenderRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeGenderRepository.getAll().size());
        Assert.assertEquals(all.size(), employeeGenderRepository.getAll().size());
    }
}