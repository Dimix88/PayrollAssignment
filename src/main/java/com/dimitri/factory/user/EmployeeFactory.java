package com.dimitri.factory.user;

import com.dimitri.domain.user.Employee;
import com.dimitri.util.Misc;

public class EmployeeFactory {

    public static Employee buildEmployee(String firstName, String lastName){
        return new Employee.Builder()
                .employeeNumber(Misc.generateId())
                .employeeFirstName(firstName)
                .employeeLastName(lastName)
                .build();
    }

}
