package com.dimitri.repository.demography.impl;

import com.dimitri.domain.demography.Race;
import com.dimitri.factory.demography.RaceFactory;
import com.dimitri.repository.demography.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {

    private RaceRepository raceRepository;
    private Race race;
    private Set<Race> races;

    @Before
    public void setUp() throws Exception {
        this.raceRepository = RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.buildRace("Col");
        this.races = new HashSet<>();
        races.add(this.raceRepository.create(race));
    }


    @Test
    public void a_create() {
        Race race2 = RaceFactory.buildRace("Indian");
        races.add(this.raceRepository.create(race2));
        String name = "Indian";
        Assert.assertEquals(races.size(), this.raceRepository.getAll().size());
        Assert.assertEquals(name,race2.getRaceDescription());
        Assert.assertNotNull(races);
        Assert.assertEquals(race2, this.raceRepository.read(race2.getRaceId()));
        System.out.println(race.toString());
    }

    @Test
    public void b_update() {
        String newName = "Black";
        Race raceNew = new Race.Builder().copy(race).raceDescription(newName).build();
        races.add(this.raceRepository.update(raceNew));
        System.out.println("In update, about to be updated = " + raceNew);
        Assert.assertEquals(raceNew, this.raceRepository.read(raceNew.getRaceId()));

    }

    @Test
    public void e_delete() {
        Race deleteRace =  RaceFactory.buildRace("Asian");
        races.add(this.raceRepository.create(deleteRace));
        races.remove(deleteRace);
        this.raceRepository.delete(deleteRace.getRaceId());
        Race result = this.raceRepository.read(deleteRace.getRaceId());
        System.out.println(races);
        Assert.assertFalse(this.raceRepository.getAll().iterator().next().getRaceId().contains("Asian"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {
        Race read = this.raceRepository.read(race.getRaceId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getRaceId(), this.raceRepository.read(read.getRaceId()).getRaceId());
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.raceRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.raceRepository.getAll().size());
        Assert.assertEquals(all.size(),this.raceRepository.getAll().size());
    }
}