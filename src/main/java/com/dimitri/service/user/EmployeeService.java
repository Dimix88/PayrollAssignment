package com.dimitri.service.user;

import com.dimitri.domain.user.Employee;
import com.dimitri.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
