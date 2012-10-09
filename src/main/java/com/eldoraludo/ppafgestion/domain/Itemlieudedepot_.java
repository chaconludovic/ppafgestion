/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity_.e.vm.java
 */
package com.eldoraludo.ppafgestion.domain;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.eldoraludo.ppafgestion.domain.Contact;
import com.eldoraludo.ppafgestion.domain.Item;
import com.eldoraludo.ppafgestion.domain.Lieudedepot;
import com.eldoraludo.ppafgestion.domain.Membreppaf;

@StaticMetamodel(Itemlieudedepot.class)
public abstract class Itemlieudedepot_ {

    // Raw attributes
    public static volatile SingularAttribute<Itemlieudedepot, Integer> id;
    public static volatile SingularAttribute<Itemlieudedepot, Date> date;
    public static volatile SingularAttribute<Itemlieudedepot, Integer> quantite;
    public static volatile SingularAttribute<Itemlieudedepot, Integer> prixunitaire;
    public static volatile SingularAttribute<Itemlieudedepot, String> note;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Itemlieudedepot, Integer> itemId;
    public static volatile SingularAttribute<Itemlieudedepot, Integer> contactId;
    public static volatile SingularAttribute<Itemlieudedepot, Integer> lieudedepotId;
    public static volatile SingularAttribute<Itemlieudedepot, Integer> membreppafId;

    // Many to one
    public static volatile SingularAttribute<Itemlieudedepot, Membreppaf> membreppaf;
    public static volatile SingularAttribute<Itemlieudedepot, Item> item;
    public static volatile SingularAttribute<Itemlieudedepot, Lieudedepot> lieudedepot;
    public static volatile SingularAttribute<Itemlieudedepot, Contact> contact;
}