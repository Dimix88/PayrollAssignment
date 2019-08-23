package com.dimitri.domain.user;

import com.dimitri.domain.demography.Race;

import java.util.Objects;

public class EmployeeRace implements Comparable<EmployeeRace> {
    private String employeeNumber;
    private String raceId;

    private EmployeeRace(){}

    public EmployeeRace(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.raceId = builder.raceId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getRaceId() {
        return raceId;
    }

    public static class Builder{
        String employeeNumber;
        String raceId;

        public Builder employeeNumber(String employeeNumber){
            this.employeeNumber = employeeNumber;
            return this;
        }
        public Builder raceId(String raceId){
            this.raceId = raceId;
            return this;
        }
        public Builder copy(EmployeeRace employeeRace){
            this.employeeNumber = employeeRace.employeeNumber;
            this.raceId = employeeRace.raceId;
            return this;
        }
        public EmployeeRace build(){
            return new EmployeeRace(this);
        }
    }

    @Override
    public int compareTo(EmployeeRace o) {
        return this.employeeNumber.compareTo(o.employeeNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRace)) return false;
        EmployeeRace that = (EmployeeRace) o;
        return employeeNumber.equals(that.employeeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }

    @Override
    public String toString() {
        return "EmployeeRace{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", raceId='" + raceId + '\'' +
                '}';
    }
}
