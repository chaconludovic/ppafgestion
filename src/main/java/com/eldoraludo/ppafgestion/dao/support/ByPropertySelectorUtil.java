/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/support/ByPropertySelectorUtil.p.vm.java
 */
package com.eldoraludo.ppafgestion.dao.support;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.eldoraludo.ppafgestion.dao.support.JpaUtil;
import com.eldoraludo.ppafgestion.dao.support.PropertySelector;

/**
 * Helper to create a predicate out of {@link PropertySelector}s.
 */
public class ByPropertySelectorUtil {
    @SuppressWarnings("unchecked")
    public static <E> Predicate byPropertySelectors(Root<E> root, CriteriaBuilder builder, final List<PropertySelector<?, ?>> selectors) {
        List<Predicate> predicates = newArrayList();

        for (PropertySelector<?, ?> selector : selectors) {
            if (selector.isBoolean()) {
                byBooleanSelector(root, builder, predicates, (PropertySelector<E, Boolean>) selector);
            } else {
                byObjectSelector(root, builder, predicates, (PropertySelector<E, ?>) selector);
            }
        }
        return JpaUtil.andPredicate(predicates, builder);
    }

    private static <E> void byBooleanSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates, PropertySelector<E, Boolean> selector) {
        if (selector.isNotEmpty()) {
            List<Predicate> selectorPredicates = newArrayList();

            for (Boolean selection : selector.getSelected()) {
                Predicate p = null;
                if (selection != null) {
                    if (selection) {
                        p = builder.isTrue(root.get(selector.getField()));
                    } else {
                        p = builder.isFalse(root.get(selector.getField()));
                    }
                } else {
                    p = builder.isNull(root.get(selector.getField()));
                }
                selectorPredicates.add(p);
            }
            predicates.add(JpaUtil.orPredicate(selectorPredicates, builder));
        }
    }

    private static <E> void byObjectSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates, PropertySelector<E, ?> selector) {
        if (selector.isNotEmpty()) {
            List<Predicate> selectorPredicates = newArrayList();

            for (Object selection : selector.getSelected()) {
                Predicate p = null;
                if (selection != null) {
                    p = builder.equal(root.get(selector.getField()), selection);
                } else {
                    p = builder.isNull(root.get(selector.getField()));
                }
                selectorPredicates.add(p);
            }
            predicates.add(JpaUtil.orPredicate(selectorPredicates, builder));
        }
    }
}
