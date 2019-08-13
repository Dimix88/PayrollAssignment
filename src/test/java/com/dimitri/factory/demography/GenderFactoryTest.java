package com.dimitri.factory.demography;

import com.dimitri.domain.demography.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    @Test
    public void buildGender() {
        Gender gender = GenderFactory.buildGender("Male");
        Assert.assertEquals("Male", gender.getGenderDescription());
        Assert.assertNotNull(gender.getGenderId());
        System.out.println(gender.getGenderId());
        Assert.assertNotNull(gender);
    }
}