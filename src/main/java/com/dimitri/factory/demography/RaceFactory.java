package com.dimitri.factory.demography;

import com.dimitri.domain.demography.Race;
import com.dimitri.util.Misc;

public class RaceFactory {

    public static Race buildRace(String raceDesc){
        return new Race.Builder()
                .raceId(Misc.generateId())
                .raceDescription(raceDesc)
                .build();
    }

}
