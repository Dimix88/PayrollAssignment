package com.dimitri.service.user;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.service.IService;

import java.util.Set;

public interface EmployeeGenderService extends IService<EmployeeGender,String> {
    Set<EmployeeGender>getAll();
}
