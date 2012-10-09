/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/RepositoryImpl.e.vm.java
 */
package com.eldoraludo.ppafgestion.repository;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

import com.eldoraludo.ppafgestion.dao.support.GenericDao;
import com.eldoraludo.ppafgestion.repository.support.RepositoryImpl;
import com.eldoraludo.ppafgestion.domain.Lieudedepot;
import com.eldoraludo.ppafgestion.dao.LieudedepotDao;

/**
 * Default implementation of the {@link LieudedepotRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see LieudedepotRepository
 */
@Named("lieudedepotRepository")
@Singleton
public class LieudedepotRepositoryImpl extends RepositoryImpl<Lieudedepot, Integer> implements LieudedepotRepository {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(LieudedepotRepositoryImpl.class);

    protected LieudedepotDao lieudedepotDao;

    @Inject
    public void setLieudedepotDao(LieudedepotDao lieudedepotDao) {
        this.lieudedepotDao = lieudedepotDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Lieudedepot, Integer> getDao() {
        return lieudedepotDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lieudedepot getNew() {
        return new Lieudedepot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lieudedepot getNewWithDefaults() {
        Lieudedepot result = getNew();
        result.initDefaultValues();
        return result;
    }

}