package com.dimitri.repository.user.impl;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.repository.user.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {

    private static EmployeeGenderRepository repository = null;

    private Set<EmployeeGender> employeeGenders;


    private EmployeeGenderRepositoryImpl(){
        this.employeeGenders = new HashSet<>();
    }

    public static EmployeeGenderRepository getRepository(){
        if (repository == null) repository = new EmployeeGenderRepositoryImpl();
        return repository;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        this.employeeGenders.add(employeeGender);
        return employeeGender;
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        //EmployeeGender em = new EmployeeGender.Builder().copy(employeeGender).employeeFirstName(); #Due to using SET this is not needed
        EmployeeGender toDelete = search(employeeGender.getGenderId());
        if (toDelete != null){
            this.employeeGenders.remove(toDelete);
            return create(employeeGender);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        EmployeeGender toDelete = read(s);
        if (toDelete != null) {
            this.employeeGenders.remove(toDelete);
        }
    }

    @Override
    public EmployeeGender read(final String s) {
        return search(s);
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenders;
    }

    private EmployeeGender search(String id){
        for(EmployeeGender empGender: employeeGenders){
            if(empGender.getEmployeeNumber().equals(id)){
                return empGender;
            }
        }
        return null;
    }
}
