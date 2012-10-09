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
import com.eldoraludo.ppafgestion.domain.Lieudestockage;
import com.eldoraludo.ppafgestion.repository.LieudestockageRepository;
import com.eldoraludo.ppafgestion.web.converter.GenericJsfConverter;

/**
 * Responsible for creating Lieudestockage JSF converters.
 * Each converter provides a 'print' method to convert an entity instance to a friendly string representation (readable by humans...).
 */
@Component
public class LieudestockageConverter extends GenericJsfConverter<Lieudestockage, Integer> {
    @Inject
    public LieudestockageConverter(LieudestockageRepository lieudestockageRepository) {
        super(lieudestockageRepository, Integer.class);
    }

    @Override
    public String print(Lieudestockage lieudestockage) {
        return lieudestockage == null ? "" : "" + lieudestockage.getRue() + "/" + lieudestockage.getVille() + "/" + lieudestockage.getCodepostal();
    }
}