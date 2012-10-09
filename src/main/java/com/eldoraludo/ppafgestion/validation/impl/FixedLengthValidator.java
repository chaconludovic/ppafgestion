/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/validation/impl/FixedLengthValidator.p.vm.java
 */
package com.eldoraludo.ppafgestion.validation.impl;

import static org.apache.commons.lang.StringUtils.isEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.eldoraludo.ppafgestion.validation.FixedLength;

public class FixedLengthValidator implements ConstraintValidator<FixedLength, String> {

    private FixedLength constraint;

    public void initialize(FixedLength constraint) {
        this.constraint = constraint;
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isEmpty(value)) {
            return constraint.nullable();
        }
        return value.length() == constraint.length();
    }
}
