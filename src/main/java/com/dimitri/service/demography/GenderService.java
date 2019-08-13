package com.dimitri.service.demography;

import com.dimitri.domain.demography.Gender;
import com.dimitri.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender,String> {
    Set<Gender>getAll();
}
