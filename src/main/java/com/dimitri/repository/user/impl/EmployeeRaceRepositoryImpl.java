package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.EmployeeRace;
import com.dimitri.repository.user.EmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {

    private static EmployeeRaceRepository repository = null;

    private Set<EmployeeRace> employeeRaces;


    private EmployeeRaceRepositoryImpl(){
        this.employeeRaces = new HashSet<>();
    }

    public static EmployeeRaceRepository getRepository(){
        if (repository == null) repository = new EmployeeRaceRepositoryImpl();
        return repository;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        this.employeeRaces.add(employeeRace);
        return employeeRace;
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        //EmployeeGender em = new EmployeeGender.Builder().copy(employeeGender).employeeFirstName(); #Due to using SET this is not needed
        EmployeeRace toDelete = search(employeeRace.getEmployeeNumber());
        if (toDelete != null){
            this.employeeRaces.remove(toDelete);
            return create(employeeRace);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        EmployeeRace toDelete = read(s);
        if (toDelete != null) {
            this.employeeRaces.remove(toDelete);
        }
    }

    @Override
    public EmployeeRace read(final String s) {
        return search(s);
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return this.employeeRaces;
    }

    private EmployeeRace search(String id){
        for(EmployeeRace empRace: employeeRaces){
            if(empRace.getEmployeeNumber().equals(id)){
                return empRace;
            }
        }
        return null;
    }
}
