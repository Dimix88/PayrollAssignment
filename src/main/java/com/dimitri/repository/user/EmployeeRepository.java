package com.dimitri.repository.user;

import com.dimitri.domain.user.Employee;
import com.dimitri.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}

