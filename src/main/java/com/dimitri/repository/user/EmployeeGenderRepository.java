package com.dimitri.repository.user;

import com.dimitri.domain.user.EmployeeGender;
import com.dimitri.repository.IRepository;

import java.util.Set;

public interface EmployeeGenderRepository extends IRepository<EmployeeGender, String> {
    Set<EmployeeGender> getAll();
}

