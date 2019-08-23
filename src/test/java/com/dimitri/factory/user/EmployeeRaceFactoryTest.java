package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeRace;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceFactoryTest {

    @Test
    public void buildEmployeeRace() {
        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace("1111","2222");
        String raceNr = "2222";
        Assert.assertNotNull(employeeRace);
        Assert.assertEquals(raceNr,employeeRace.getRaceId());
        System.out.println(employeeRace);
    }
}