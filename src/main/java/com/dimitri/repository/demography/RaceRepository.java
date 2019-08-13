package com.dimitri.repository.demography;

import com.dimitri.domain.demography.Race;
import com.dimitri.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race,String> {
    Set<Race>getAll();
}
