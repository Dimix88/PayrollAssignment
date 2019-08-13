package com.dimitri.controller.user;

import com.dimitri.domain.user.Employee;
import com.dimitri.service.user.EmployeeService;

public class EmployeeController {
    private EmployeeService service = null;

    public Employee create(Employee employee){
        return service.create(employee);
    }

    public Employee update(Employee employee){
        return service.update(employee);
    }

    public void delete(String s){
        service.delete(s);
    }

    public Employee read(String s){
        return service.read(s);
    }


}
