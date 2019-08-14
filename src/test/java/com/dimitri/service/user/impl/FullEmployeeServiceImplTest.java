package com.dimitri.service.user.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FullEmployeeServiceImplTest {
    FullEmployeeServiceImpl full;
    @Before
    public void setUp() throws Exception {
        full = new FullEmployeeServiceImpl();
    }

    @Test
    public void fullEmployee() {
        full.fullEmployee("Dimitri","Ferus","Male","Coloured");
        Assert.assertNotNull(full);
        System.out.println(full.toString());
    }
}