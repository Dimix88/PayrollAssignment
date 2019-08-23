package com.dimitri.controller.user;

import com.dimitri.domain.demography.Race;
import com.dimitri.domain.user.Employee;
import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.factory.demography.RaceFactory;
import com.dimitri.factory.user.EmployeeGenderFactory;
import com.dimitri.repository.demography.impl.RaceRepositoryImpl;
import com.dimitri.service.demography.RaceService;
import com.dimitri.service.user.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderController {

    private EmployeeGenderService service = null;
    private RaceService raceService = null;


    public EmployeeGender create(EmployeeGender employeeGender){
        return this.service.create(employeeGender);
    }

    public EmployeeGender update(EmployeeGender employeeGender){
        return this.service.create(employeeGender);
    }
    public void read(String id){
        this.service.read(id);
    }
    public Set<EmployeeGender>getAll(){
        return this.service.getAll();
    }
    public void delete(String id){
        this.service.delete(id);
    }

    public Employee createEmployee(String fName,String lName, String gender,String race){
        return null;
    }
}
