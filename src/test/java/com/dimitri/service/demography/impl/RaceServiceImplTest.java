package com.dimitri.service.demography.impl;

import com.dimitri.domain.demography.Race;
import com.dimitri.factory.demography.RaceFactory;
import com.dimitri.repository.demography.RaceRepository;
import com.dimitri.repository.demography.impl.RaceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {

    private RaceRepository raceRepository;
    private Race race;
    private Set<Race> races;

    @Before
    public void setUp() throws Exception {
        this.raceRepository = RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.buildRace("Col");
        this.races = new HashSet<>();
        this.raceRepository.create(race);
    }


    @Test
    public void a_create() {
        /*Employee created = this.employeeRepository.create(this.employee);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);*/

        String name = "Col";
        Assert.assertEquals(1, this.raceRepository.getAll().size());
        Assert.assertEquals(name,race.getRaceDescription());
        Assert.assertNotNull(races);
        System.out.println(race.toString());
    }

    @Test
    public void b_update() {
        String newName = "Black";
        Race raceNew = new Race.Builder().copy(race).raceDescription(newName).build();
        this.raceRepository.create(raceNew);
        System.out.println("In update, about to be updated = " + raceNew);
        races.add(this.raceRepository.update(raceNew));
        Assert.assertEquals(raceNew, this.raceRepository.read(raceNew.getRaceId()));

    }

    @Test
    public void e_delete() {

        this.raceRepository.delete(race.getRaceId());
        System.out.println(races);
    }

    @Test
    public void c_read() {

        System.out.println("In read, courseId = "+ race.getRaceId());
        Race read = this.raceRepository.read(race.getRaceId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(race.getRaceId(), this.raceRepository.read(race.getRaceId()).getRaceId());
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.raceRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.raceRepository.getAll().size());
    }
}