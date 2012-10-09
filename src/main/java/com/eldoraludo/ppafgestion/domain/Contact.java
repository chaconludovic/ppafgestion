/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity.e.vm.java
 */
package com.eldoraludo.ppafgestion.domain;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.eldoraludo.ppafgestion.domain.PersistableHashBuilder;
import com.google.common.base.Objects;

@Entity
@Table(name = "CONTACT")
@Cache(usage = NONSTRICT_READ_WRITE)
public class Contact implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Contact.class);

    // Raw attributes
    private Integer id; // pk
    private String nom; // not null
    private String prenom; // not null
    private String numerotelephone1;
    private String numerotelephone2;
    private String email;
    private Boolean actif; // not null
    private String note;
    private String rue;
    private String ville;
    private String codepostal;
    private String infosuppl;

    // ---------------------------
    // Constructors
    // ---------------------------

    public Contact() {
    }

    public Contact(Integer primaryKey) {
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

    // -- [nom] ------------------------

    @Size(max = 100)
    @NotEmpty
    @Column(name = "NOM", nullable = false, length = 100)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // -- [prenom] ------------------------

    @Size(max = 100)
    @NotEmpty
    @Column(name = "PRENOM", nullable = false, length = 100)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // -- [numerotelephone1] ------------------------

    @Size(max = 100)
    @Column(name = "NUMEROTELEPHONE1", length = 100)
    public String getNumerotelephone1() {
        return numerotelephone1;
    }

    public void setNumerotelephone1(String numerotelephone1) {
        this.numerotelephone1 = numerotelephone1;
    }

    // -- [numerotelephone2] ------------------------

    @Size(max = 100)
    @Column(name = "NUMEROTELEPHONE2", length = 100)
    public String getNumerotelephone2() {
        return numerotelephone2;
    }

    public void setNumerotelephone2(String numerotelephone2) {
        this.numerotelephone2 = numerotelephone2;
    }

    // -- [email] ------------------------

    @Size(max = 100)
    @Email
    @Column(name = "EMAIL", length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // -- [actif] ------------------------

    @NotNull
    @Column(name = "ACTIF", nullable = false, length = 1)
    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
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

    // -- [rue] ------------------------

    @Size(max = 100)
    @Column(name = "RUE", length = 100)
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    // -- [ville] ------------------------

    @Size(max = 100)
    @Column(name = "VILLE", length = 100)
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // -- [codepostal] ------------------------

    @Size(max = 100)
    @Column(name = "CODEPOSTAL", length = 100)
    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    // -- [infosuppl] ------------------------

    @Size(max = 2147483647)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "INFOSUPPL")
    @Lob
    public String getInfosuppl() {
        return infosuppl;
    }

    public void setInfosuppl(String infosuppl) {
        this.infosuppl = infosuppl;
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
        return this == other || (other instanceof Contact && hashCode() == other.hashCode());
    }

    private PersistableHashBuilder persistableHashBuilder = new PersistableHashBuilder();

    @Override
    public int hashCode() {
        return persistableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Contact instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("nom", getNom()) //
                .add("prenom", getPrenom()) //
                .add("numerotelephone1", getNumerotelephone1()) //
                .add("numerotelephone2", getNumerotelephone2()) //
                .add("email", getEmail()) //
                .add("actif", getActif()) //
                .add("note", getNote()) //
                .add("rue", getRue()) //
                .add("ville", getVille()) //
                .add("codepostal", getCodepostal()) //
                .add("infosuppl", getInfosuppl()) //
                .toString();
    }
}