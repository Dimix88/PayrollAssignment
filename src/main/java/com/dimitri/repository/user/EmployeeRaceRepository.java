package com.dimitri.repository.user;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.repository.IRepository;

import java.util.Set;

public interface EmployeeRaceRepository extends IRepository<EmployeeRace,String> {
    Set<EmployeeRace>getAll();
}
