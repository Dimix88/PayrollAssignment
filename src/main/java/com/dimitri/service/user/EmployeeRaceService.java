package com.dimitri.service.user;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.service.IService;

import java.util.Set;

public interface EmployeeRaceService extends IService<EmployeeRace,String> {
    Set<EmployeeRace>getAll();
}
