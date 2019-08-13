package com.dimitri.repository.demography.impl;

import com.dimitri.domain.demography.Gender;
import com.dimitri.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepository genderRepository = null;

    private Set<Gender>genders;


    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    public static GenderRepository getRepository(){
        if (genderRepository == null) genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {
        //Employee em = new Employee.Builder().copy(employee).employeeFirstName(); #Due to using SET this is not needed
        Gender toDelete = search(gender.getGenderId());
        if (toDelete != null){
            genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Gender toDelete = search(s);
        if (toDelete != null) {
            this.genders.remove(toDelete);
        }
    }

    @Override
    public Gender read(final String s) {
        return search(s);
    }

    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }

    private Gender search(String id){
        for(Gender genderSearch:this.genders){
            if(genderSearch.getGenderId().equals(id))
                return genderSearch;
        }
        return null;
    }
}
