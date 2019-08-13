package com.dimitri.domain.demography;

import java.util.Objects;

public class Gender implements Comparable<Gender>{

    private String genderId, genderDescription;

    private Gender(){}


    public Gender(Builder builder){
        this.genderId = builder.genderId;
        this.genderDescription = builder.genderDescription;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id='" + genderId + '\'' +
                ", description='" + genderDescription + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gender o) {
        return this.getGenderId().compareTo(o.getGenderId());
    }

    public static class Builder {
        private String genderId, genderDescription;

        public Builder genderId(String genderId){
            this.genderId = genderId;
            return this;
        }

        public Builder genderDescription(String genderDescription){
            this.genderDescription = genderDescription;
            return this;
        }
        public Builder copy(Gender gender){
            this.genderId = gender.genderId;
            this.genderDescription = gender.genderDescription;
            return this;
        }

        public Gender build(){
            return new Gender(this);
        }
    }
}
