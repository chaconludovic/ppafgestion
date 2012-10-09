/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/SearchForm.e.vm.java
 */
package com.eldoraludo.ppafgestion.web.domain;

import static com.eldoraludo.ppafgestion.dao.support.EntitySelectors.RolemembreSelector.newRolemembreSelector;
import static com.eldoraludo.ppafgestion.dao.support.PropertySelectors.BooleanSelector.newBooleanSelector;
import static com.eldoraludo.ppafgestion.domain.Membreppaf_.actif;
import static com.eldoraludo.ppafgestion.domain.Membreppaf_.rolemembreId;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.eldoraludo.ppafgestion.dao.support.EntitySelectors.RolemembreSelector;
import com.eldoraludo.ppafgestion.dao.support.PropertySelectors.BooleanSelector;
import com.eldoraludo.ppafgestion.domain.Membreppaf;
import com.eldoraludo.ppafgestion.web.domain.support.SearchFormBase;

/**
 * Simple parameters holder for membreppaf search.
 */
@Component
@Scope("session")
public class MembreppafSearchForm extends SearchFormBase {
    private static final long serialVersionUID = 1L;

    private Membreppaf membreppaf = new Membreppaf();
    private BooleanSelector<Membreppaf> actifSelector = newBooleanSelector(actif);
    private RolemembreSelector<Membreppaf> rolemembreSelector = newRolemembreSelector(rolemembreId);

    public Membreppaf getMembreppaf() {
        return membreppaf;
    }

    // Selectors for property
    public BooleanSelector<Membreppaf> getActifSelector() {
        return actifSelector;
    }

    // Selectors for x-to-one associations
    public RolemembreSelector<Membreppaf> getRolemembreSelector() {
        return rolemembreSelector;
    }
}