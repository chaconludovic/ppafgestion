/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/converter/ApplicationConversionService.p.vm.java
 */
package com.eldoraludo.ppafgestion.web.converter;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.faces.model.converter.FacesConversionService;

@Named("conversionService")
@Singleton
public class ApplicationConversionService extends FacesConversionService {

    @Override
    protected void addDefaultConverters() {
        super.addDefaultConverters();

        // register custom converters below (eg converter for String => composite pk)
    }
}