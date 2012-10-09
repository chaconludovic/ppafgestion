/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.eldoraludo.ppafgestion.web.domain;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import com.eldoraludo.ppafgestion.dao.support.SearchParameters;
import com.eldoraludo.ppafgestion.domain.Membreppaf;
import com.eldoraludo.ppafgestion.repository.MembreppafRepository;
import com.eldoraludo.ppafgestion.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class MembreppafLazyDataModel extends GenericLazyDataModel<Membreppaf> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private MembreppafRepository membreppafRepository;
    @Inject
    transient private MembreppafSearchForm membreppafSearchForm;

    /**
     * Prepare the search parameters and call the membreppafRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Membreppaf> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = membreppafSearchForm.getSearchParameters();

        // property selectors
        sp.clearPropertySelectors();
        sp.addPropertySelector(membreppafSearchForm.getActifSelector());

        // entity selectors
        sp.clearEntitySelectors();
        sp.addEntitySelector(membreppafSearchForm.getRolemembreSelector());

        Membreppaf membreppaf = membreppafSearchForm.getMembreppaf();
        setRowCount(membreppafRepository.findCount(membreppaf, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return membreppafRepository.find(membreppaf, sp);
    }
}