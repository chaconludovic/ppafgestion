/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/SearchForm.e.vm.java
 */
package com.eldoraludo.ppafgestion.web.domain;

import static com.eldoraludo.ppafgestion.dao.support.EntitySelectors.MembreppafSelector.newMembreppafSelector;
import static com.eldoraludo.ppafgestion.dao.support.PropertySelectors.BooleanSelector.newBooleanSelector;
import static com.eldoraludo.ppafgestion.domain.Utilisateur_.actif;
import static com.eldoraludo.ppafgestion.domain.Utilisateur_.membreppafId;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.eldoraludo.ppafgestion.dao.support.EntitySelectors.MembreppafSelector;
import com.eldoraludo.ppafgestion.dao.support.PropertySelectors.BooleanSelector;
import com.eldoraludo.ppafgestion.domain.Utilisateur;
import com.eldoraludo.ppafgestion.web.domain.support.SearchFormBase;

/**
 * Simple parameters holder for utilisateur search.
 */
@Component
@Scope("session")
public class UtilisateurSearchForm extends SearchFormBase {
    private static final long serialVersionUID = 1L;

    private Utilisateur utilisateur = new Utilisateur();
    private BooleanSelector<Utilisateur> actifSelector = newBooleanSelector(actif);
    private MembreppafSelector<Utilisateur> membreppafSelector = newMembreppafSelector(membreppafId);

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // Selectors for property
    public BooleanSelector<Utilisateur> getActifSelector() {
        return actifSelector;
    }

    // Selectors for x-to-one associations
    public MembreppafSelector<Utilisateur> getMembreppafSelector() {
        return membreppafSelector;
    }
}