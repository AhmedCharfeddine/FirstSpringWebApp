package com.exercise.demo.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "personne")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Last name is missing")
    private String nom;

    @NotBlank(message = "First name is missing")
    private String prenom;

    @PositiveOrZero(message = "Title is missing") // should be 0, 1, or 2
    private Integer civilite;

    @NotBlank(message = "Address is missing")
    private String adresse;

    @NotNull(message = "Birth date is missing")
    private Date naissance;

    public PersonEntity(String nom, String prenom, Integer civilite, String adresse, Date naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.adresse = adresse;
        this.naissance = naissance;
    }

    public PersonEntity() {
        super();
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getCivilite() {
        return this.civilite;
    }

    public void setCivilite(Integer civilite) {
        this.civilite = civilite;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getNaissance() {
        return this.naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", civilite='" + getCivilite() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", naissance='" + getNaissance() + "'" +
            "}";
    }

}
