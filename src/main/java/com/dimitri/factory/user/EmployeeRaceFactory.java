package com.dimitri.factory.user;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.util.Misc;

public class EmployeeRaceFactory {
    public static EmployeeRace buildEmployeeRace(){
        return new EmployeeRace.Builder().employeeNumber(Misc.generateId())
                .raceId(Misc.generateId())
                .build();
    }
}
