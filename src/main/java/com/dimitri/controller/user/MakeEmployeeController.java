package com.dimitri.controller.user;

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

import java.util.Map;

public class MakeEmployeeController {

   private EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();
   private GenderService genderService = GenderServiceImpl.getGenderService();
   private RaceService raceService = RaceServiceImpl.getRaceService();
   private EmployeeGenderService employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
   private EmployeeRaceService employeeRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();

   public Employee createFullEmp(String fName, String lName, String gen, String ra){
       Employee emp = EmployeeFactory.buildEmployee(fName,lName);
       employeeService.create(emp);

       Gender gender = GenderFactory.buildGender(gen);
       genderService.create(gender);

       Race race = RaceFactory.buildRace(ra);
       raceService.create(race);

       EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender();
       employeeGenderService.create(employeeGender);

       EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace();
       employeeRaceService.create(employeeRace);
       return emp;
   }
}
