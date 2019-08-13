package com.dimitri.service.user;

import com.dimitri.domain.user.Employee;
import com.dimitri.service.IService;

public interface EmployeeService extends IService<Employee, String> {
    void getAll();
}
