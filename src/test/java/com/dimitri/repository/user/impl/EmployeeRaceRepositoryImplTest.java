package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.Employee;
import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.factory.user.EmployeeRaceFactory;
import com.dimitri.repository.user.EmployeeRaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRaceRepositoryImplTest {

    private EmployeeRaceRepository employeeRaceRepository;
    private EmployeeRace employeeRace;
    private Set<EmployeeRace> employeeRaces;

    @Before
    public void setUp() throws Exception {
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getRepository();
        this.employeeRace = EmployeeRaceFactory.buildEmployeeRace("11111","5555");
        this.employeeRaces = new HashSet<>();
        employeeRaces.add(employeeRaceRepository.create(employeeRace));
    }


    @Test
    public void a_create() {
        EmployeeRace employeeRace2 = EmployeeRaceFactory.buildEmployeeRace("11","22");
        employeeRaces.add(employeeRaceRepository.create(employeeRace2));
        Assert.assertEquals(employeeRace2,employeeRaceRepository.read(employeeRace2.getEmployeeNumber()));
        Assert.assertNotNull(employeeRaces);
        System.out.println(employeeRace2.toString());
    }

    @Test
    public void b_update() {
        String newNumber = "222222";
        EmployeeRace employeeRaceNew = new EmployeeRace.Builder().copy(employeeRace).raceId(newNumber).build();
        System.out.println("In update, about to be updated = " + employeeRaceNew);
        employeeRaces.add(this.employeeRaceRepository.update(employeeRaceNew));
        System.out.println(employeeRaceRepository.read(employeeRaceNew.getEmployeeNumber()));
        Assert.assertEquals(employeeRaceNew, this.employeeRaceRepository.read(employeeRaceNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {
        EmployeeRace deleteEmployeeRace = EmployeeRaceFactory.buildEmployeeRace("55","66");
        employeeRaces.add(employeeRaceRepository.create(deleteEmployeeRace));
        employeeRaces.remove(deleteEmployeeRace);
        this.employeeRaceRepository.delete(deleteEmployeeRace.getEmployeeNumber());
        EmployeeRace result = employeeRaceRepository.read(deleteEmployeeRace.getEmployeeNumber());
        Assert.assertFalse(employeeRaceRepository.getAll().iterator().next().getEmployeeNumber().contains("55"));
        Assert.assertNull(result);
        System.out.println(employeeRaces);
    }

    @Test
    public void c_read() {

        EmployeeRace read = this.employeeRaceRepository.read(employeeRace.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getEmployeeNumber(), this.employeeRaceRepository.read(employeeRace.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<EmployeeRace> all = this.employeeRaceRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeRaceRepository.getAll().size());
        Assert.assertEquals(all, employeeRaceRepository.getAll());
    }
}