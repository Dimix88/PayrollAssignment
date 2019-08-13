package com.dimitri.service.user.impl;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.repository.user.EmployeeGenderRepository;
import com.dimitri.repository.user.impl.EmployeeGenderRepositoryImpl;
import com.dimitri.service.user.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {

    private static EmployeeGenderService service = null;
    private EmployeeGenderRepository employeeGenderRepository;

    private EmployeeGenderServiceImpl(){
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getRepository();
    }
    public static EmployeeGenderService getEmployeeGenderService(){
        if (service == null) service = new EmployeeGenderServiceImpl();
        return service;
    }
    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenderRepository.getAll();
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return this.employeeGenderRepository.create(employeeGender);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return this.employeeGenderRepository.update(employeeGender);
    }

    @Override
    public void delete(String s) {
        this.employeeGenderRepository.delete(s);
    }

    @Override
    public EmployeeGender read(String s) {
        return this.employeeGenderRepository.read(s);
    }
}
