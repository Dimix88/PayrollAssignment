package com.dimitri.service.demography.impl;

import com.dimitri.domain.demography.Race;
import com.dimitri.factory.demography.RaceFactory;
import com.dimitri.repository.demography.RaceRepository;
import com.dimitri.repository.demography.impl.RaceRepositoryImpl;
import com.dimitri.service.demography.RaceService;
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

    private RaceService raceService;
    private Race race;

    @Before
    public void setUp() throws Exception {
        this.raceService = RaceServiceImpl.getRaceService();
        this.race = RaceFactory.buildRace("Col");
        this.raceService.create(race);
    }


    @Test
    public void a_create() {
        Race race2 = RaceFactory.buildRace("Indian");
        this.raceService.create(race2);
        String name = "Indian";
        Assert.assertEquals(name,race2.getRaceDescription());
        Assert.assertEquals(race2,this.raceService.read(race2.getRaceId()));
        System.out.println(race2.toString());
    }

    @Test
    public void b_update() {
        String newName = "Black";
        Race raceNew = new Race.Builder().copy(race).raceDescription(newName).build();
        this.raceService.update(raceNew);
        System.out.println("In update, about to be updated = " + raceNew);
        Assert.assertEquals(raceNew, this.raceService.read(raceNew.getRaceId()));

    }

    @Test
    public void e_delete() {
        Race deleteRace = RaceFactory.buildRace("Asian");
        this.raceService.create(deleteRace);
        this.raceService.delete(deleteRace.getRaceId());
        Race result = raceService.read(deleteRace.getRaceId());
        Assert.assertFalse(this.raceService.getAll().iterator().next().getRaceDescription().contains("Asian"));
        Assert.assertNull(result);
    }

    @Test
    public void c_read() {
        Race read = this.raceService.read(race.getRaceId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read.getRaceId(), this.raceService.read(read.getRaceId()).getRaceId());
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.raceService.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(all.size(), this.raceService.getAll().size());
        Assert.assertEquals(all.size(),this.raceService.getAll().size());
    }
}