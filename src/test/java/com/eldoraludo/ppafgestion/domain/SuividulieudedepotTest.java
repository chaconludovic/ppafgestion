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
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import com.eldoraludo.ppafgestion.domain.Lieudedepot;
import com.eldoraludo.ppafgestion.domain.Membreppaf;

/**
 * Basic tests for Suividulieudedepot
 */
@SuppressWarnings("unused")
public class SuividulieudedepotTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Suividulieudedepot model = new Suividulieudedepot();
        assertFalse(model.isIdSet());
    }

    @Test
    public void isIdSetReturnsTrue() {
        Suividulieudedepot model = new Suividulieudedepot();
        model.setId(ValueGenerator.getUniqueInteger());
        assertNotNull(model.getId());
        assertTrue(model.isIdSet());
    }

    // test columns methods

    //-------------------------------------------------------------
    // Many to One:  Suividulieudedepot.membreppafId ==> Membreppaf.id
    //-------------------------------------------------------------

    @Test
    public void manyToOne_setMembreppaf() {
        Suividulieudedepot many = new Suividulieudedepot();

        // init
        Membreppaf one = new Membreppaf();

        one.setId(ValueGenerator.getUniqueInteger());
        many.setMembreppaf(one);

        // make sure it is propagated properly
        assertNotNull(many.getMembreppafId());
        assertEquals(one, many.getMembreppaf());
        assertSame(many.getMembreppafId(), one.getId());
        // now set it to back to null
        many.setMembreppaf(null);

        // make sure null is propagated properly
        assertNull(many.getMembreppaf());

        // make sure it is propagated on fk column as well
        assertNull(many.getMembreppafId());
    }

    @Test
    public void manyToOne_setLieudedepot() {
        Suividulieudedepot many = new Suividulieudedepot();

        // init
        Lieudedepot one = new Lieudedepot();

        one.setId(ValueGenerator.getUniqueInteger());
        many.setLieudedepot(one);

        // make sure it is propagated properly
        assertNotNull(many.getLieudedepotId());
        assertEquals(one, many.getLieudedepot());
        assertSame(many.getLieudedepotId(), one.getId());
        // now set it to back to null
        many.setLieudedepot(null);

        // make sure null is propagated properly
        assertNull(many.getLieudedepot());

        // make sure it is propagated on fk column as well
        assertNull(many.getLieudedepotId());
    }

    @Test
    public void toStringNotNull() {
        Suividulieudedepot model = new Suividulieudedepot();
        assertNotNull(model.toString());
    }

    @Test
    public void equalsUsingPk() {
        Suividulieudedepot model1 = new Suividulieudedepot();
        Suividulieudedepot model2 = new Suividulieudedepot();

        Integer id = ValueGenerator.getUniqueInteger();
        model1.setId(id);
        model2.setId(id);

        model1.setDate(new Date());
        model2.setDate(new Date());

        model1.setNote("a");
        model2.setNote("a");
        assertTrue(model1.isIdSet());
        assertTrue(model2.isIdSet());
        assertTrue(model1.hashCode() == model2.hashCode());
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
    }
}