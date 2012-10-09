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

import com.eldoraludo.ppafgestion.domain.Lieudestockage;
import com.eldoraludo.ppafgestion.repository.LieudestockageRepository;
import com.eldoraludo.ppafgestion.web.converter.domain.LieudestockageConverter;
import com.eldoraludo.ppafgestion.web.util.MessageUtil;

/**
 * Thin controller layer allowing you to do business validation and other conditional 
 * checks that are easier to implement in Java than in webflow's xml syntax.
 */
@Named
@Singleton
public class LieudestockageController {
    private static final long serialVersionUID = 1L;

    @Inject
    private LieudestockageRepository lieudestockageRepository;

    @Inject
    private MessageUtil messageUtil;

    @Inject
    private LieudestockageConverter lieudestockageConverter;

    public Lieudestockage newIfNull(Lieudestockage lieudestockage) {
        if (lieudestockage != null) {
            return lieudestockage;
        }

        return lieudestockageRepository.getNewWithDefaults();
    }

    public boolean save(Lieudestockage lieudestockage) {
        lieudestockageRepository.save(lieudestockage);
        messageUtil.info("status_saved_ok", lieudestockageConverter.print(lieudestockage));
        return true;
    }

    public boolean saveAndClose(Lieudestockage lieudestockage) {
        lieudestockageRepository.save(lieudestockage);
        messageUtil.infoDelayed("status_saved_ok", lieudestockageConverter.print(lieudestockage));
        forceClose();
        return true;
    }

    public boolean delete(Lieudestockage lieudestockage) {
        String infoArg = lieudestockageConverter.print(lieudestockage);
        lieudestockageRepository.delete(lieudestockage);
        messageUtil.info("status_deleted_ok", infoArg);
        return true;
    }
}