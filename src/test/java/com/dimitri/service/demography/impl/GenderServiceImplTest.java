package com.dimitri.service.demography.impl;

import com.dimitri.domain.demography.Gender;
import com.dimitri.factory.demography.GenderFactory;
import com.dimitri.repository.demography.GenderRepository;
import com.dimitri.repository.demography.impl.GenderRepositoryImpl;
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

    private GenderRepository genderRepository;
    private Gender gender;
    private Set<Gender> genders;

    @Before
    public void setUp() throws Exception {
        this.genderRepository = GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.buildGender("Male");
        this.genders = new HashSet<>();
        this.genderRepository.create(gender);
    }


    @Test
    public void a_create() {
        /*Employee created = this.employeeRepository.create(this.employee);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);*/

        String name = "Male";
        Assert.assertEquals(1, this.genderRepository.getAll().size());
        Assert.assertEquals(name,gender.getGenderDescription());
        Assert.assertNotNull(genders);
        System.out.println(gender.toString());
    }

    @Test
    public void b_update() {
        String newName = "Female";
        Gender genderNew = new Gender.Builder().copy(gender).genderDescription(newName).build();
        this.genderRepository.create(genderNew);
        System.out.println("In update, about to be updated = " + genderNew);
        genders.add(this.genderRepository.update(genderNew));
        Assert.assertEquals(genderNew, this.genderRepository.read(genderNew.getGenderId()));

    }

    @Test
    public void e_delete() {

        this.genderRepository.delete(gender.getGenderId());
        System.out.println(genders);
    }

    @Test
    public void c_read() {

        System.out.println("In read, courseId = "+ gender.getGenderId());
        Gender read = this.genderRepository.read(gender.getGenderId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(gender.getGenderId(), this.genderRepository.read(gender.getGenderId()).getGenderId());
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.genderRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.genderRepository.getAll().size());
    }
}