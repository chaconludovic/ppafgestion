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
import com.eldoraludo.ppafgestion.domain.Item;
import com.eldoraludo.ppafgestion.domain.Lieudestockage;

@StaticMetamodel(Itemlieudestockage.class)
public abstract class Itemlieudestockage_ {

    // Raw attributes
    public static volatile SingularAttribute<Itemlieudestockage, Integer> id;
    public static volatile SingularAttribute<Itemlieudestockage, Date> date;
    public static volatile SingularAttribute<Itemlieudestockage, Integer> quantite;
    public static volatile SingularAttribute<Itemlieudestockage, String> note;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Itemlieudestockage, Integer> itemId;
    public static volatile SingularAttribute<Itemlieudestockage, Integer> lieudestockageId;

    // Many to one
    public static volatile SingularAttribute<Itemlieudestockage, Lieudestockage> lieudestockage;
    public static volatile SingularAttribute<Itemlieudestockage, Item> item;
}