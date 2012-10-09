/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/RepositoryImpl.e.vm.java
 */
package com.eldoraludo.ppafgestion.repository;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;
import org.springframework.transaction.annotation.Transactional;

import com.eldoraludo.ppafgestion.dao.support.GenericDao;
import com.eldoraludo.ppafgestion.repository.support.RepositoryImpl;
import com.eldoraludo.ppafgestion.domain.Role;
import com.eldoraludo.ppafgestion.dao.RoleDao;

/**
 * Default implementation of the {@link RoleRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see RoleRepository
 */
@Named("roleRepository")
@Singleton
public class RoleRepositoryImpl extends RepositoryImpl<Role, Integer> implements RoleRepository {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RoleRepositoryImpl.class);

    protected RoleDao roleDao;

    @Inject
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Role, Integer> getDao() {
        return roleDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getNew() {
        return new Role();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getNewWithDefaults() {
        Role result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Role get(Role model) {
        if (model == null) {
            return null;
        }

        if (model.isIdSet()) {
            return super.get(model);
        }

        if (!isNotEmpty(model.getRoleName())) {
            Role result = getByRoleName(model.getRoleName());
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Role getByRoleName(String _roleName) {
        Role role = new Role();
        role.setRoleName(_roleName);
        return findUniqueOrNone(role);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteByRoleName(String roleName) {
        delete(getByRoleName(roleName));
    }
}