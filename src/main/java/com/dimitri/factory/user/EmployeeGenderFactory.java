package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.util.Misc;

public class EmployeeGenderFactory {

    public static EmployeeGender buildEmployeeGender(String empId,String genId){
        return new EmployeeGender.Builder()
                .employeeNumber(empId)
                .genderId(genId)
                .build();
    }
}
