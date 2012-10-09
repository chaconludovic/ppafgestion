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

import com.eldoraludo.ppafgestion.domain.Suividulieudedepot;
import com.eldoraludo.ppafgestion.repository.SuividulieudedepotGenerator;
import com.eldoraludo.ppafgestion.dao.SuividulieudedepotDao;

/**
 * Integration test on SuividulieudedepotDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class SuividulieudedepotDaoImplIT {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(SuividulieudedepotDaoImplIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private SuividulieudedepotDao suividulieudedepotDao;

    @Inject
    private SuividulieudedepotGenerator suividulieudedepotGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Suividulieudedepot suividulieudedepot = suividulieudedepotGenerator.getSuividulieudedepot();

        // add it to a Set before saving (force equals/hashcode)
        Set<Suividulieudedepot> set = newHashSet(suividulieudedepot, suividulieudedepot);
        assertThat(set).hasSize(1);

        suividulieudedepotDao.save(suividulieudedepot);
        entityManager.flush();

        // reload it from cache and check equality
        Suividulieudedepot model = new Suividulieudedepot();
        model.setId(suividulieudedepot.getId());
        assertThat(suividulieudedepot).isEqualTo(suividulieudedepotDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(suividulieudedepot.getId()).isEqualTo(suividulieudedepotDao.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(suividulieudedepot).isNotEqualTo(suividulieudedepotDao.get(model));
    }
}