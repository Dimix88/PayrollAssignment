package com.dimitri.repository.demography.impl;

import com.dimitri.domain.demography.Gender;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.repository.demography.GenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private GenderRepository genderRepository;
    private Gender gender;
    private Set<Gender> genders;

    @Before
    public void setUp() throws Exception {
        this.genderRepository = GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.buildGender("Male");
        this.genders = new HashSet<>();
        genders.add(this.genderRepository.create(gender));
    }


    @Test
    public void a_create() {
        Gender gender2 = GenderFactory.buildGender("Male");
        genders.add(genderRepository.create(gender2));
        String name = "Male";
        Assert.assertEquals(genders.size(), this.genderRepository.getAll().size());
        Assert.assertEquals(name,gender2.getGenderDescription());
        Assert.assertNotNull(genders);
        Assert.assertEquals(gender2,genderRepository.read(gender2.getGenderId()));
        System.out.println(gender2.toString());
    }

    @Test
    public void b_update() {
        String newName = "Female";
        Gender genderNew = new Gender.Builder().copy(gender).genderDescription(newName).build();
        genders.add(this.genderRepository.update(genderNew));
        System.out.println("In update, about to be updated = " + genderNew);
        Assert.assertEquals(genderNew, this.genderRepository.read(genderNew.getGenderId()));

    }

    @Test
    public void e_delete() {
        Gender deleteGender = GenderFactory.buildGender("Males");
        genders.add(this.genderRepository.create(deleteGender));
        genders.remove(deleteGender);
        this.genderRepository.delete(deleteGender.getGenderId());
        Gender result = this.genderRepository.read(deleteGender.getGenderId());
        System.out.println(genders);
        Assert.assertFalse(genderRepository.getAll().iterator().next().getGenderDescription().contains("Males"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {

        System.out.println("In read, courseId = "+ gender.getGenderId());
        Gender read = this.genderRepository.read(gender.getGenderId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getGenderId(), this.genderRepository.read(read.getGenderId()).getGenderId());
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.genderRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.genderRepository.getAll().size());
        Assert.assertEquals(all.size(), this.genderRepository.getAll().size());
    }
}
