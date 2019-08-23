package com.dimitri.service.demography.impl;

import com.dimitri.domain.demography.Gender;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.repository.demography.GenderRepository;
import com.dimitri.repository.demography.impl.GenderRepositoryImpl;
import com.dimitri.service.demography.GenderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {

    private GenderService genderService;
    private Gender gender;


    @Before
    public void setUp() throws Exception {
        this.genderService = GenderServiceImpl.getGenderService();
        this.gender = GenderFactory.buildGender("Male");
        this.genderService.create(gender);
    }


    @Test
    public void a_create() {
        Gender gender2 = GenderFactory.buildGender("Male");
        this.genderService.create(gender2);
        String name = "Male";
        Assert.assertEquals(name,gender2.getGenderDescription());
        Assert.assertEquals(gender2,this.genderService.read(gender2.getGenderId()));
        System.out.println(gender2.toString());
    }

    @Test
    public void b_update() {
        String newName = "Female";
        Gender genderNew = new Gender.Builder().copy(gender).genderDescription(newName).build();
        this.genderService.update(genderNew);
        System.out.println("In update, about to be updated = " + genderNew);
        Assert.assertEquals(genderNew, this.genderService.read(genderNew.getGenderId()));

    }

    @Test
    public void e_delete() {
        Gender deleteGender = GenderFactory.buildGender("Males");
        this.genderService.create(deleteGender);
        this.genderService.delete(deleteGender.getGenderId());
        Gender result = genderService.read(deleteGender.getGenderId());
        Assert.assertFalse(genderService.getAll().iterator().next().getGenderDescription().contains("Males"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {
        Gender read = this.genderService.read(gender.getGenderId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getGenderId(), this.genderService.read(read.getGenderId()).getGenderId());
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.genderService.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.genderService.getAll().size());
        Assert.assertEquals(all.size(),this.genderService.getAll().size());
    }
}