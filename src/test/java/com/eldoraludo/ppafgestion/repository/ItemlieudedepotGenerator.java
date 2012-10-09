/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.eldoraludo.ppafgestion.repository;

import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import com.eldoraludo.ppafgestion.domain.Contact;
import com.eldoraludo.ppafgestion.domain.Item;
import com.eldoraludo.ppafgestion.domain.Itemlieudedepot;
import com.eldoraludo.ppafgestion.domain.Lieudedepot;
import com.eldoraludo.ppafgestion.domain.Membreppaf;
import com.eldoraludo.ppafgestion.repository.ContactGenerator;
import com.eldoraludo.ppafgestion.repository.ContactRepository;
import com.eldoraludo.ppafgestion.repository.ItemGenerator;
import com.eldoraludo.ppafgestion.repository.ItemRepository;
import com.eldoraludo.ppafgestion.repository.LieudedepotGenerator;
import com.eldoraludo.ppafgestion.repository.LieudedepotRepository;
import com.eldoraludo.ppafgestion.repository.MembreppafGenerator;
import com.eldoraludo.ppafgestion.repository.MembreppafRepository;
import com.eldoraludo.ppafgestion.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@SuppressWarnings("unused")
@Named
@Singleton
public class ItemlieudedepotGenerator {

    /**
     * Returns a new Itemlieudedepot instance filled with random values.
     */
    public Itemlieudedepot getItemlieudedepot() {
        Itemlieudedepot itemlieudedepot = new Itemlieudedepot();

        // simple attributes follows
        itemlieudedepot.setDate(new Date());
        itemlieudedepot.setQuantite(1);
        itemlieudedepot.setPrixunitaire(1);
        itemlieudedepot.setNote("a");
        // mandatory relation
        Membreppaf membreppaf = membreppafGenerator.getMembreppaf();
        membreppafRepository.save(membreppaf);
        itemlieudedepot.setMembreppaf(membreppaf);
        // mandatory relation
        Item item = itemGenerator.getItem();
        itemRepository.save(item);
        itemlieudedepot.setItem(item);
        // mandatory relation
        Lieudedepot lieudedepot = lieudedepotGenerator.getLieudedepot();
        lieudedepotRepository.save(lieudedepot);
        itemlieudedepot.setLieudedepot(lieudedepot);
        // mandatory relation
        Contact contact = contactGenerator.getContact();
        contactRepository.save(contact);
        itemlieudedepot.setContact(contact);
        return itemlieudedepot;
    }

    @Inject
    private MembreppafRepository membreppafRepository;
    @Inject
    private MembreppafGenerator membreppafGenerator;
    @Inject
    private ItemRepository itemRepository;
    @Inject
    private ItemGenerator itemGenerator;
    @Inject
    private LieudedepotRepository lieudedepotRepository;
    @Inject
    private LieudedepotGenerator lieudedepotGenerator;
    @Inject
    private ContactRepository contactRepository;
    @Inject
    private ContactGenerator contactGenerator;
}