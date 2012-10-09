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
import com.eldoraludo.ppafgestion.domain.Itemlieudedepot;
import com.eldoraludo.ppafgestion.repository.ItemlieudedepotRepository;
import com.eldoraludo.ppafgestion.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class ItemlieudedepotLazyDataModel extends GenericLazyDataModel<Itemlieudedepot> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private ItemlieudedepotRepository itemlieudedepotRepository;
    @Inject
    transient private ItemlieudedepotSearchForm itemlieudedepotSearchForm;

    /**
     * Prepare the search parameters and call the itemlieudedepotRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Itemlieudedepot> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = itemlieudedepotSearchForm.getSearchParameters();

        // ranges
        sp.clearRanges();
        sp.addRange(itemlieudedepotSearchForm.getDateRange());
        sp.addRange(itemlieudedepotSearchForm.getQuantiteRange());
        sp.addRange(itemlieudedepotSearchForm.getPrixunitaireRange());

        // entity selectors
        sp.clearEntitySelectors();
        sp.addEntitySelector(itemlieudedepotSearchForm.getMembreppafSelector());
        sp.addEntitySelector(itemlieudedepotSearchForm.getItemSelector());
        sp.addEntitySelector(itemlieudedepotSearchForm.getLieudedepotSelector());
        sp.addEntitySelector(itemlieudedepotSearchForm.getContactSelector());

        Itemlieudedepot itemlieudedepot = itemlieudedepotSearchForm.getItemlieudedepot();
        setRowCount(itemlieudedepotRepository.findCount(itemlieudedepot, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return itemlieudedepotRepository.find(itemlieudedepot, sp);
    }
}