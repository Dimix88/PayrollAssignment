package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.util.Misc;

public class EmployeeGenderFactory {

    public static EmployeeGender buildEmployeeGender(String empFirst,String empLast,String genderDesc){
        return new EmployeeGender.Builder().employeeNumber(Misc.generateId())
                .employeeFirstName(empFirst)
                .employeeLastName(empLast)
                .genderId(Misc.generateId())
                .genderDescription(genderDesc)
                .build();
    }
}
