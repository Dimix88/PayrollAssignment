package com.dimitri.factory.demography;

import com.dimitri.domain.demography.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void buildRace() {
        Race race = RaceFactory.buildRace("Coloured");
        String raceName = "Coloured";
        Assert.assertEquals(raceName,race.getRaceDescription());
        Assert.assertNotNull(race);
        System.out.println(race);
    }
}