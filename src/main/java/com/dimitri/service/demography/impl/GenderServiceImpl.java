package com.dimitri.service.demography.impl;

import com.dimitri.domain.demography.Gender;
import com.dimitri.repository.demography.GenderRepository;
import com.dimitri.repository.demography.impl.GenderRepositoryImpl;
import com.dimitri.service.demography.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {
    private static GenderService service = null;
    private GenderRepository repository;

    private GenderServiceImpl(){
        this.repository = GenderRepositoryImpl.getRepository();
    }
    public static GenderService getGenderService(){
        if (service == null) service = new GenderServiceImpl();
        return service;
    }
    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }
}
