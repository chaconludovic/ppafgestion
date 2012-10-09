/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity.e.vm.java
 */
package com.eldoraludo.ppafgestion.domain;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import com.eldoraludo.ppafgestion.domain.Contact;
import com.eldoraludo.ppafgestion.domain.Membreppaf;
import com.eldoraludo.ppafgestion.domain.PersistableHashBuilder;
import com.google.common.base.Objects;

@Entity
@Table(name = "SUIVICONTACT")
@Cache(usage = NONSTRICT_READ_WRITE)
public class Suivicontact implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Suivicontact.class);

    // Raw attributes
    private Integer id; // pk
    private Date date; // not null
    private Date dateprochainappel;
    private String note;

    // Technical attributes for query by example
    private Integer contactId; // not null
    private Integer membreppafId; // not null

    // Many to one
    private Membreppaf membreppaf; // not null (membreppafId)
    private Contact contact; // not null (contactId)

    // ---------------------------
    // Constructors
    // ---------------------------

    public Suivicontact() {
    }

    public Suivicontact(Integer primaryKey) {
        setId(primaryKey);
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [id] ------------------------

    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [date] ------------------------

    @NotNull
    @Column(name = "`DATE`", nullable = false, length = 8)
    @Temporal(DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // -- [dateprochainappel] ------------------------

    @Column(name = "DATEPROCHAINAPPEL", length = 8)
    @Temporal(DATE)
    public Date getDateprochainappel() {
        return dateprochainappel;
    }

    public void setDateprochainappel(Date dateprochainappel) {
        this.dateprochainappel = dateprochainappel;
    }

    // -- [note] ------------------------

    @Size(max = 2147483647)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "NOTE")
    @Lob
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // -- [contactId] ------------------------

    @Column(name = "CONTACT_ID", nullable = false, precision = 10, insertable = false, updatable = false)
    public Integer getContactId() {
        return contactId;
    }

    private void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    // -- [membreppafId] ------------------------

    @Column(name = "MEMBREPPAF_ID", nullable = false, precision = 10, insertable = false, updatable = false)
    public Integer getMembreppafId() {
        return membreppafId;
    }

    private void setMembreppafId(Integer membreppafId) {
        this.membreppafId = membreppafId;
    }

    // --------------------------------------------------------------------
    // Many to One support
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Suivicontact.membreppafId ==> Membreppaf.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinColumn(name = "MEMBREPPAF_ID", nullable = false)
    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    public Membreppaf getMembreppaf() {
        return membreppaf;
    }

    /**
     * Set the membreppaf without adding this Suivicontact instance on the passed membreppaf
     * If you want to preserve referential integrity we recommend to use
     * instead the corresponding adder method provided by {@link Membreppaf}
     */
    public void setMembreppaf(Membreppaf membreppaf) {
        this.membreppaf = membreppaf;

        // We set the foreign key property so it can be used by our JPA search by Example facility.
        if (membreppaf != null) {
            setMembreppafId(membreppaf.getId());
        } else {
            setMembreppafId(null);
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Suivicontact.contactId ==> Contact.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinColumn(name = "CONTACT_ID", nullable = false)
    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    public Contact getContact() {
        return contact;
    }

    /**
     * Set the contact without adding this Suivicontact instance on the passed contact
     * If you want to preserve referential integrity we recommend to use
     * instead the corresponding adder method provided by {@link Contact}
     */
    public void setContact(Contact contact) {
        this.contact = contact;

        // We set the foreign key property so it can be used by our JPA search by Example facility.
        if (contact != null) {
            setContactId(contact.getId());
        } else {
            setContactId(null);
        }
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    /**
     * equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Suivicontact && hashCode() == other.hashCode());
    }

    private PersistableHashBuilder persistableHashBuilder = new PersistableHashBuilder();

    @Override
    public int hashCode() {
        return persistableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Suivicontact instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("date", getDate()) //
                .add("dateprochainappel", getDateprochainappel()) //
                .add("note", getNote()) //
                .add("contactId", getContactId()) //
                .add("membreppafId", getMembreppafId()) //
                .toString();
    }
}