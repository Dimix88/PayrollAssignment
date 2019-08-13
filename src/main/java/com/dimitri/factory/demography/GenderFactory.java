package com.dimitri.factory.demography;

import com.dimitri.domain.demography.Gender;
import com.dimitri.util.Misc;

public class GenderFactory {

    public static Gender buildGender(String genderDesc){
        return new Gender.Builder()
                .genderId(Misc.generateId())
                .genderDescription(genderDesc)
                .build();
    }
}
