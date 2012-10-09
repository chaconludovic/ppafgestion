/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/Controller.e.vm.java
 */
package com.eldoraludo.ppafgestion.web.domain;

import static com.eldoraludo.ppafgestion.web.util.PrimeFacesUtil.forceClose;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.eldoraludo.ppafgestion.domain.Role;
import com.eldoraludo.ppafgestion.repository.RoleRepository;
import com.eldoraludo.ppafgestion.web.converter.domain.RoleConverter;
import com.eldoraludo.ppafgestion.web.util.MessageUtil;

/**
 * Thin controller layer allowing you to do business validation and other conditional 
 * checks that are easier to implement in Java than in webflow's xml syntax.
 */
@Named
@Singleton
public class RoleController {
    private static final long serialVersionUID = 1L;

    @Inject
    private RoleRepository roleRepository;

    @Inject
    private MessageUtil messageUtil;

    @Inject
    private RoleConverter roleConverter;

    public Role newIfNull(Role role) {
        if (role != null) {
            return role;
        }

        return roleRepository.getNewWithDefaults();
    }

    public boolean save(Role role) {
        roleRepository.save(role);
        messageUtil.info("status_saved_ok", roleConverter.print(role));
        return true;
    }

    public boolean saveAndClose(Role role) {
        roleRepository.save(role);
        messageUtil.infoDelayed("status_saved_ok", roleConverter.print(role));
        forceClose();
        return true;
    }

    public boolean delete(Role role) {
        String infoArg = roleConverter.print(role);
        roleRepository.delete(role);
        messageUtil.info("status_deleted_ok", infoArg);
        return true;
    }
}