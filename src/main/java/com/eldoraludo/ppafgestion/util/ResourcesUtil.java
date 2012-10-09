/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/util/ResourcesUtil.p.vm.java
 */
package com.eldoraludo.ppafgestion.util;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceResourceBundle;

/**
 * ResourcesUtil allows you to retrieve localized resources for the locale present in the current thread of execution.
 * It can be used from both Spring beans (simple dependency injection) and from non spring beans. In the later case,
 * you obtain the reference thanks to the static method ResourcesUtil.getInstance()
 */
@Named
@Singleton
@Lazy(false)
public class ResourcesUtil {

    private static ResourcesUtil instance;
    private static MessageSource messageSource;

    private Map<Locale, ResourceBundle> cache = newHashMap();

    @Inject
    public ResourcesUtil(MessageSource ms) {
        messageSource = ms;
        instance = this;
    }

    /**
     * Call it from non spring aware code to obtain a reference to the ResourcesUtil singleton instance.
     */
    public static ResourcesUtil getInstance() {
        return instance;
    }

    /**
     * Return the MessageSource that backs this ResourcesUtil.
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Return the underlying spring MessageSource as a ResourceBundle.
     */
    public ResourceBundle getAsResourceBundle() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle rb = cache.get(locale);

        if (rb == null) {
            rb = new MessageSourceResourceBundle(messageSource, locale);
            cache.put(locale, rb);
        }

        return rb;
    }

    /**
     * Return the property value for the contextual locale.
     * If no value is found, the passed key is returned.
     */
    public String getProperty(String key) {
        return getProperty(key, null);
    }

    /**
     * Return the property value for the contextual locale.
     * If no value is found, the passed key is returned.
     */
    public String getProperty(String key, Object[] args) {
        if (key == null) {
            return "";
        }

        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}