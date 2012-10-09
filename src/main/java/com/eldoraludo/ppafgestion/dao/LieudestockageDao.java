/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/DAOImpl.e.vm.java
 */
package com.eldoraludo.ppafgestion.dao;

import javax.inject.Named;
import javax.inject.Singleton;
import com.eldoraludo.ppafgestion.dao.LieudestockageDao;
import com.eldoraludo.ppafgestion.dao.support.GenericDao;
import com.eldoraludo.ppafgestion.domain.Lieudestockage;

/**
 * JPA 2 Data Access Object for {@link com.eldoraludo.ppafgestion.domain.Lieudestockage}.
 * Note: do not use @Transactional in the DAO layer.
 */
@Named
@Singleton
public class LieudestockageDao extends GenericDao<Lieudestockage, Integer> {
    public LieudestockageDao() {
        super(Lieudestockage.class);
    }
}