package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.util.Misc;

public class EmployeeGenderFactory {

    public static EmployeeGender buildEmployeeGender(){
        return new EmployeeGender.Builder().employeeNumber(Misc.generateId())
                .genderId(Misc.generateId())
                .build();
    }
}
