package com.dimitri.service.demography.impl;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.factory.user.EmployeeGenderFactory;
import com.dimitri.factory.user.EmployeeRaceFactory;
import com.dimitri.repository.user.impl.EmployeeRaceRepositoryImpl;
import com.dimitri.service.user.EmployeeRaceService;
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


    private EmployeeRaceService employeeRaceService;
    private EmployeeRace employeeRace;

    @Before
    public void setUp() throws Exception {
        this.employeeRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();
        this.employeeRace = EmployeeRaceFactory.buildEmployeeRace("4443","1177");
        this.employeeRaceService.create(employeeRace);
    }


    @Test
    public void a_create() {
        EmployeeRace employeeRace2 = EmployeeRaceFactory.buildEmployeeRace("1111","2222");
        this.employeeRaceService.create(employeeRace2);
        String newNumber = employeeRace2.getEmployeeNumber();
        Assert.assertEquals(newNumber,employeeRace2.getEmployeeNumber());
        Assert.assertNotNull(employeeRace2);
        Assert.assertEquals(employeeRace2,this.employeeRaceService.read(employeeRace2.getEmployeeNumber()));
        System.out.println(employeeRace2.toString());
    }

    @Test
    public void b_update() {
        String newNumber = "222222";
        EmployeeRace employeeRaceNew = new EmployeeRace.Builder().copy(employeeRace).raceId(newNumber).build();
        this.employeeRaceService.create(employeeRaceNew);
        System.out.println("In update, about to be updated = " + employeeRaceNew);
        Assert.assertEquals(employeeRaceNew, this.employeeRaceService.read(employeeRaceNew.getEmployeeNumber()));

    }

    @Test
    public void e_delete() {
        EmployeeRace deleteEmployeeRace = EmployeeRaceFactory.buildEmployeeRace("4444","9999");
        employeeRaceService.create(deleteEmployeeRace);
        employeeRaceService.delete(deleteEmployeeRace.getEmployeeNumber());
        EmployeeRace result = this.employeeRaceService.read(deleteEmployeeRace.getEmployeeNumber());
        Assert.assertFalse(this.employeeRaceService.getAll().iterator().next().getEmployeeNumber().contains("4444"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {
        EmployeeRace read = this.employeeRaceService.read(employeeRace.getEmployeeNumber());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getEmployeeNumber(), this.employeeRaceService.read(employeeRace.getEmployeeNumber()).getEmployeeNumber());
    }

    @Test
    public void d_getAll() {
        Set<EmployeeRace> all = this.employeeRaceService.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.employeeRaceService.getAll().size());
        Assert.assertEquals(all.size(), this.employeeRaceService.getAll().size());
    }
}