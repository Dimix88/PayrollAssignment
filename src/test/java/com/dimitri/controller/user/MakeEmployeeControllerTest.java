package com.dimitri.controller.user;

import com.dimitri.domain.demography.Gender;
import com.dimitri.domain.demography.Race;
import com.dimitri.domain.user.Employee;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.factory.demography.RaceFactory;
import com.dimitri.service.demography.GenderService;
import com.dimitri.service.demography.RaceService;
import com.dimitri.service.demography.impl.EmployeeRaceServiceImpl;
import com.dimitri.service.demography.impl.GenderServiceImpl;
import com.dimitri.service.demography.impl.RaceServiceImpl;
import com.dimitri.service.user.EmployeeGenderService;
import com.dimitri.service.user.EmployeeRaceService;
import com.dimitri.service.user.EmployeeService;
import com.dimitri.service.user.impl.EmployeeGenderServiceImpl;
import com.dimitri.service.user.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MakeEmployeeControllerTest {
    private static MakeEmployeeController controller = new MakeEmployeeController();
    private Employee emp;
    private Race race;
    private Gender gender;
    private GenderService genderService;
    private RaceService raceService;

    @Before
    public void setUp() throws Exception {
        genderService = GenderServiceImpl.getGenderService();
        raceService = RaceServiceImpl.getRaceService();
        race = RaceFactory.buildRace("Coloured");
        gender = GenderFactory.buildGender("Male");

    }

    @Test
    public void createFullEmp() {
        emp = controller.createFullEmp("Dimitri","Ferus",gender.getGenderDescription(),race.getRaceDescription());
        genderService.create(gender);
        raceService.create(race);
        String raceNumber = race.getRaceId();
        String genderNumber = gender.getGenderId();
        Assert.assertNotNull(emp);
        System.out.println(emp);
        Assert.assertEquals("Male",genderService.read(genderNumber).getGenderDescription());
        Assert.assertEquals("Coloured",raceService.read(raceNumber).getRaceDescription());

    }
}