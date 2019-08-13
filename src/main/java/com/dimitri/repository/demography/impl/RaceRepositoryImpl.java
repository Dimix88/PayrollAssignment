package com.dimitri.repository.demography.impl;

import com.dimitri.domain.demography.Race;
import com.dimitri.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepository raceRepository = null;

    private Set<Race>races;


    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepository getRepository(){
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race update(Race race) {
        //Employee em = new Employee.Builder().copy(employee).employeeFirstName(); #Due to using SET this is not needed
        Race toDelete = search(race.getRaceId());
        if (toDelete != null){
            races.remove(toDelete);
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Race toDelete = search(s);
        if (toDelete != null) {
            this.races.remove(toDelete);
        }
    }

    @Override
    public Race read(final String s) {
        return search(s);
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    private Race search(String id){
        for(Race raceSearch:this.races){
            if(raceSearch.getRaceId().equals(id))
                return raceSearch;
        }
        return null;
    }
}
