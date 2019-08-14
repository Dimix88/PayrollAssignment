package com.dimitri.domain.user;

import com.dimitri.domain.demography.Gender;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.factory.user.EmployeeFactory;

import java.util.Objects;

public class EmployeeGender implements Comparable<EmployeeGender>{

    //Convert to Builder pattern

    private String employeeNumber;
    private String genderId;

    public EmployeeGender(){
    }
    public EmployeeGender(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.genderId = builder.genderId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getGenderId() {
        return genderId;
    }

    public static class Builder{
            private String employeeNumber;
            private String genderId;

            public Builder employeeNumber(String employeeNumber){
                this.employeeNumber = employeeNumber;
                return this;
            }

            public Builder genderId(String genderId){
                this.genderId = genderId;
                return this;
            }
            public Builder copy(EmployeeGender employeeGender){
                this.employeeNumber = employeeGender.getEmployeeNumber();
                this.genderId = employeeGender.getGenderId();
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
        return employeeNumber.equals(that.employeeNumber) &&
                genderId.equals(that.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, genderId);
    }

    @Override
    public int compareTo(EmployeeGender o) {
        return this.employeeNumber.compareTo(o.employeeNumber);
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
