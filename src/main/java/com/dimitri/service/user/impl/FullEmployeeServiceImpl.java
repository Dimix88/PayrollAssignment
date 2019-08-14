package com.dimitri.service.user.impl;

import com.dimitri.domain.demography.Gender;
import com.dimitri.domain.demography.Race;
import com.dimitri.domain.user.Employee;
import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.factory.demography.RaceFactory;
import com.dimitri.factory.user.EmployeeFactory;
import com.dimitri.factory.user.EmployeeGenderFactory;
import com.dimitri.factory.user.EmployeeRaceFactory;
import com.dimitri.service.demography.impl.GenderServiceImpl;
import com.dimitri.service.demography.impl.RaceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FullEmployeeServiceImpl {

    public void fullEmployee(String name, String lastName, String gender, String race){
        Employee emp = EmployeeFactory.buildEmployee(name,lastName);
        Gender gen = GenderFactory.buildGender(gender);
        Race r = RaceFactory.buildRace(race);

        EmployeeServiceImpl.getEmployeeService().create(emp);
        GenderServiceImpl.getGenderService().create(gen);
        RaceServiceImpl.getRaceService().create(r);

    }
}
