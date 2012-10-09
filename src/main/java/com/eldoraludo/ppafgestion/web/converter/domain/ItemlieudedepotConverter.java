/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/converter/EntityConverter.e.vm.java
 */
package com.eldoraludo.ppafgestion.web.converter.domain;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.eldoraludo.ppafgestion.domain.Itemlieudedepot;
import com.eldoraludo.ppafgestion.repository.ItemlieudedepotRepository;
import com.eldoraludo.ppafgestion.web.converter.GenericJsfConverter;

/**
 * Responsible for creating Itemlieudedepot JSF converters.
 * Each converter provides a 'print' method to convert an entity instance to a friendly string representation (readable by humans...).
 */
@Component
public class ItemlieudedepotConverter extends GenericJsfConverter<Itemlieudedepot, Integer> {
    @Inject
    public ItemlieudedepotConverter(ItemlieudedepotRepository itemlieudedepotRepository) {
        super(itemlieudedepotRepository, Integer.class);
    }

    @Override
    public String print(Itemlieudedepot itemlieudedepot) {
        return itemlieudedepot == null ? "" : "" + itemlieudedepot.getNote();
    }
}