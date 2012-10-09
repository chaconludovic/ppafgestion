/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.eldoraludo.ppafgestion.domain;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

import com.eldoraludo.ppafgestion.util.*;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;

/**
 * Basic tests for Lieudedepot
 */
@SuppressWarnings("unused")
public class LieudedepotTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Lieudedepot model = new Lieudedepot();
        assertFalse(model.isIdSet());
    }

    @Test
    public void isIdSetReturnsTrue() {
        Lieudedepot model = new Lieudedepot();
        model.setId(ValueGenerator.getUniqueInteger());
        assertNotNull(model.getId());
        assertTrue(model.isIdSet());
    }

    // test columns methods

    @Test
    public void toStringNotNull() {
        Lieudedepot model = new Lieudedepot();
        assertNotNull(model.toString());
    }

    @Test
    public void equalsUsingPk() {
        Lieudedepot model1 = new Lieudedepot();
        Lieudedepot model2 = new Lieudedepot();

        Integer id = ValueGenerator.getUniqueInteger();
        model1.setId(id);
        model2.setId(id);

        model1.setNumerotelephone1("a");
        model2.setNumerotelephone1("a");

        model1.setNumerotelephone2("a");
        model2.setNumerotelephone2("a");

        model1.setRue("a");
        model2.setRue("a");

        model1.setVille("a");
        model2.setVille("a");

        model1.setCodepostal("a");
        model2.setCodepostal("a");

        model1.setInfosuppl("a");
        model2.setInfosuppl("a");

        model1.setType("a");
        model2.setType("a");
        assertTrue(model1.isIdSet());
        assertTrue(model2.isIdSet());
        assertTrue(model1.hashCode() == model2.hashCode());
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
    }
}