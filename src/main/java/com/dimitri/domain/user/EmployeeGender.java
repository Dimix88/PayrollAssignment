package com.dimitri.domain.user;

import com.dimitri.domain.demography.Gender;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.factory.user.EmployeeFactory;

import java.util.Objects;

public class EmployeeGender implements Comparable<EmployeeGender>{

    //Convert to Builder pattern

    private Employee employee;
    private Gender gender;

    public EmployeeGender(){
    }
    public EmployeeGender(Builder builder){
        this.employee = EmployeeFactory.buildEmployee(builder.employeeFirstName,builder.employeeLastName);
        this.gender = GenderFactory.buildGender(builder.genderDescription);
    }

    public String getEmployeeNumber(){
        return employee.getEmployeeNumber();
    }
   public String getEmployeeFirstName(){
        return employee.getEmployeeFirstName();
   }
   public String getEmployeeLastName(){
        return employee.getEmployeeLastName();
   }
   public String getGenderId(){
        return gender.getGenderId();
   }
   public String getGenderDescription(){
        return gender.getGenderDescription();
   }
    @Override
    public int compareTo(EmployeeGender o) {
        return this.employee.getEmployeeNumber().compareTo(o.getEmployeeNumber());
    }



    public static class Builder{
            private String employeeNumber;
            private String employeeFirstName;
            private String employeeLastName;
            private String genderId;
            private String genderDescription;

            public Builder employeeNumber(String employeeNumber){
                this.employeeNumber = employeeNumber;
                return this;
            }
            public Builder employeeFirstName(String employeeFirstName){
                this.employeeFirstName = employeeFirstName;
                return this;
            }
            public Builder employeeLastName(String employeeLastName){
                this.employeeLastName = employeeLastName;
                return this;
            }
            public Builder genderId(String genderId){
                this.genderId = genderId;
                return this;
            }
            public Builder genderDescription(String genderDescription){
                this.genderDescription = genderDescription;
                return this;
            }
            public Builder copy(EmployeeGender employeeGender){
                this.employeeNumber = employeeGender.getEmployeeNumber();
                this.employeeFirstName = employeeGender.getEmployeeFirstName();
                this.employeeLastName = employeeGender.getEmployeeLastName();
                this.genderId = employeeGender.getGenderId();
                this.genderDescription = employeeGender.getGenderDescription();
                return this;
            }
            public EmployeeGender build(){
                return new EmployeeGender(this);
            }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeGender)) return false;
        EmployeeGender that = (EmployeeGender) o;
        return employee.equals(that.employee) &&
                gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, gender);
    }
}
