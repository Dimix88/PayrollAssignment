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
    private static MakeEmployeeController controller;
    private Employee emp;




    @Test
    public void createFullEmp() {
        controller = new MakeEmployeeController();
        emp = controller.createFullEmp("Dimitri","Ferus","Male","Coloured");
        String id = emp.getEmployeeNumber();
        Assert.assertNotNull(emp);

    }
}