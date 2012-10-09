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

import com.eldoraludo.ppafgestion.domain.Itemlieudedepot;
import com.eldoraludo.ppafgestion.repository.ItemlieudedepotRepository;
import com.eldoraludo.ppafgestion.web.converter.domain.ItemlieudedepotConverter;
import com.eldoraludo.ppafgestion.web.util.MessageUtil;

/**
 * Thin controller layer allowing you to do business validation and other conditional 
 * checks that are easier to implement in Java than in webflow's xml syntax.
 */
@Named
@Singleton
public class ItemlieudedepotController {
    private static final long serialVersionUID = 1L;

    @Inject
    private ItemlieudedepotRepository itemlieudedepotRepository;

    @Inject
    private MessageUtil messageUtil;

    @Inject
    private ItemlieudedepotConverter itemlieudedepotConverter;

    public Itemlieudedepot newIfNull(Itemlieudedepot itemlieudedepot) {
        if (itemlieudedepot != null) {
            return itemlieudedepot;
        }

        return itemlieudedepotRepository.getNewWithDefaults();
    }

    public boolean save(Itemlieudedepot itemlieudedepot) {
        itemlieudedepotRepository.save(itemlieudedepot);
        messageUtil.info("status_saved_ok", itemlieudedepotConverter.print(itemlieudedepot));
        return true;
    }

    public boolean saveAndClose(Itemlieudedepot itemlieudedepot) {
        itemlieudedepotRepository.save(itemlieudedepot);
        messageUtil.infoDelayed("status_saved_ok", itemlieudedepotConverter.print(itemlieudedepot));
        forceClose();
        return true;
    }

    public boolean delete(Itemlieudedepot itemlieudedepot) {
        String infoArg = itemlieudedepotConverter.print(itemlieudedepot);
        itemlieudedepotRepository.delete(itemlieudedepot);
        messageUtil.info("status_deleted_ok", infoArg);
        return true;
    }
}