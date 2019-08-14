package com.dimitri.service.demography.impl;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.repository.user.EmployeeRaceRepository;
import com.dimitri.repository.user.impl.EmployeeRaceRepositoryImpl;
import com.dimitri.service.user.EmployeeRaceService;

import java.util.Set;

public class EmployeeRaceServiceImpl implements EmployeeRaceService {

    private static EmployeeRaceService service = null;
    private EmployeeRaceRepository employeeRaceRepository;

    private EmployeeRaceServiceImpl(){
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getRepository();
    }
    public static EmployeeRaceService getEmployeeRaceService(){
        if (service == null) service = new EmployeeRaceServiceImpl();
        return service;
    }
    @Override
    public Set<EmployeeRace> getAll() {
        return this.employeeRaceRepository.getAll();
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        return this.employeeRaceRepository.create(employeeRace);
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        return this.employeeRaceRepository.update(employeeRace);
    }

    @Override
    public void delete(String s) {
        this.employeeRaceRepository.delete(s);
    }

    @Override
    public EmployeeRace read(String s) {
        return this.employeeRaceRepository.read(s);
    }

}
