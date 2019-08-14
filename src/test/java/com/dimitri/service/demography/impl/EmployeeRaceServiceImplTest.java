package com.dimitri.service.demography.impl;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.factory.user.EmployeeRaceFactory;
import com.dimitri.repository.user.EmployeeRaceRepository;
import com.dimitri.repository.user.impl.EmployeeRaceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRaceServiceImplTest {


    private EmployeeRaceRepository employeeRaceRepository;
    private EmployeeRace employeeRace;
    private Set<EmployeeRace> employeeRaces;

    @Before
    public void setUp() throws Exception {
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getRepository();
        this.employeeRace = EmployeeRaceFactory.buildEmployeeRace();
        this.employeeRaces = new HashSet<>();
        this.employeeRaceRepository.create(employeeRace);
    }


    @Test
    public void a_create() {
        /*Employee created = this.employeeRepository.create(this.employee);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);*/

        String newNumber = employeeRace.getEmployeeNumber();
        Assert.assertEquals(1, this.employeeRaceRepository.getAll().size());
        Assert.assertEquals(newNumber,employeeRace.getEmployeeNumber());
        Assert.assertNotNull(employeeRaces);
        System.out.println(employeeRace.toString());
    }

    @Test
    public void b_update() {
        String newNumber = "222222";
        EmployeeRace employeeRaceNew = new EmployeeRace.Builder().copy(employeeRace).employeeNumber(newNumber).build();
        this.employeeRaceRepository.create(employeeRaceNew);
        System.out.println("In update, about to be updated = " + employeeRaceNew);
        employeeRaces.add(this.employeeRaceRepository.update(employeeRaceNew));
        Assert.assertEquals(employeeRaceNew, this.employeeRaceRepository.read(employeeRaceNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {

        this.employeeRaceRepository.delete(employeeRace.getEmployeeNumber());
        System.out.println(employeeRaces);
    }

    @Test
    public void c_read() {

        System.out.println("In read, courseId = "+ employeeRace.getEmployeeNumber());
        EmployeeRace read = this.employeeRaceRepository.read(employeeRace.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(employeeRace.getEmployeeNumber(), this.employeeRaceRepository.read(employeeRace.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<EmployeeRace> all = this.employeeRaceRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeRaceRepository.getAll().size());
    }
}