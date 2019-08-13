package com.dimitri.service.demography.impl;

import com.dimitri.domain.demography.Race;
import com.dimitri.repository.demography.RaceRepository;
import com.dimitri.repository.demography.impl.RaceRepositoryImpl;
import com.dimitri.service.demography.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private static RaceService service = null;
    private RaceRepository repository;

    private RaceServiceImpl(){
        this.repository = RaceRepositoryImpl.getRepository();
    }

    public static RaceService getRaceService(){
        if (service == null) service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Set<Race> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }
}
