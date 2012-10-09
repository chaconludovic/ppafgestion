/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/dao/DaoImplIT.e.vm.java
 */
package com.eldoraludo.ppafgestion.dao;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eldoraludo.ppafgestion.domain.Rolemembre;
import com.eldoraludo.ppafgestion.repository.RolemembreGenerator;
import com.eldoraludo.ppafgestion.dao.RolemembreDao;

/**
 * Integration test on RolemembreDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class RolemembreDaoImplIT {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RolemembreDaoImplIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private RolemembreDao rolemembreDao;

    @Inject
    private RolemembreGenerator rolemembreGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Rolemembre rolemembre = rolemembreGenerator.getRolemembre();

        // add it to a Set before saving (force equals/hashcode)
        Set<Rolemembre> set = newHashSet(rolemembre, rolemembre);
        assertThat(set).hasSize(1);

        rolemembreDao.save(rolemembre);
        entityManager.flush();

        // reload it from cache and check equality
        Rolemembre model = new Rolemembre();
        model.setId(rolemembre.getId());
        assertThat(rolemembre).isEqualTo(rolemembreDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(rolemembre.getId()).isEqualTo(rolemembreDao.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(rolemembre).isNotEqualTo(rolemembreDao.get(model));
    }
}