package com.dimitri.repository.demography;

import com.dimitri.domain.demography.Gender;
import com.dimitri.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender,String> {
    Set<Gender>getAll();
}
