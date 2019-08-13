package com.dimitri.service.demography;

import com.dimitri.domain.demography.Race;
import com.dimitri.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race,String> {
    Set<Race>getAll();
}
