package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.util.Misc;

public class EmployeeRaceFactory {
    public static EmployeeRace buildEmployeeRace(String empId,String raceNr){
        return new EmployeeRace.Builder().employeeNumber(empId)
                .raceId(raceNr)
                .build();
    }
}
