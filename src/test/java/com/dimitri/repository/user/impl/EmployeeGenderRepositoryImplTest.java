package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.factory.user.EmployeeGenderFactory;
import com.dimitri.repository.user.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeGenderRepositoryImplTest {

    private EmployeeGenderRepository employeeGenderRepository;
    private EmployeeGender employeeGender;
    private Set<EmployeeGender> employeeGenders;

    @Before
    public void setUp() throws Exception {
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getRepository();
        this.employeeGender = EmployeeGenderFactory.buildEmployeeGender("Dimitri", "Ferus","Male");
        this.employeeGenders = new HashSet<>();
        this.employeeGenderRepository.create(employeeGender);
    }


    @Test
    public void a_create() {
        /*Employee created = this.employeeRepository.create(this.employee);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);*/

        String name = "Dimitri";
        Assert.assertEquals(1, this.employeeGenderRepository.getAll().size());
        Assert.assertEquals(name,employeeGender.getEmployeeFirstName());
        Assert.assertNotNull(employeeGenders);
        System.out.println(employeeGender.toString());
    }

    @Test
    public void b_update() {
        String newName = "Mark";
        EmployeeGender employeeGenderNew = new EmployeeGender.Builder().copy(employeeGender).employeeFirstName(newName).build();
        this.employeeGenderRepository.create(employeeGenderNew);
        System.out.println("In update, about to be updated = " + employeeGenderNew);
        employeeGenders.add(this.employeeGenderRepository.update(employeeGenderNew));
        Assert.assertEquals(employeeGenderNew, this.employeeGenderRepository.read(employeeGenderNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {

        this.employeeGenderRepository.delete(employeeGender.getEmployeeNumber());
        System.out.println(employeeGenders);
    }

    @Test
    public void c_read() {

        System.out.println("In read, courseId = "+ employeeGender.getEmployeeNumber());
        EmployeeGender read = this.employeeGenderRepository.read(employeeGender.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(employeeGender.getEmployeeNumber(), this.employeeGenderRepository.read(employeeGender.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender> all = this.employeeGenderRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeGenderRepository.getAll().size());
    }
}