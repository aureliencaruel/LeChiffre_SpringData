package com.modele;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "voiture", indexes = { @Index(name = "idx_voiture_immatriculation", columnList = "immatriculation") })
public class Voiture {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer code;

    @Column(updatable = true, name = "nom")
    private String nom;

    @Column(updatable = true, name = "marque")
    private String marque;

    @Column(updatable = false, name = "immatriculation")
    private String immatriculation;

    @Column(updatable = false, name = "dateImmatriculation")
    private Date dateImmatriculation;

    @Column(updatable = false, name = "nbKilometres")
    private Integer nbKilometres;

    public Voiture() {
    }

    public Voiture(String nom, String marque, String immatriculation, Date dateImmatriculation, Integer nbKilometres) {
        this.nom = nom;
        this.marque = marque;
        this.immatriculation = immatriculation;
        this.dateImmatriculation = dateImmatriculation;
        this.nbKilometres = nbKilometres;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Date getDateImmatriculation() {
        return dateImmatriculation;
    }

    public void setDateImmatriculation(Date dateImmatriculation) {
        this.dateImmatriculation = dateImmatriculation;
    }

    public Integer getNbKilometres() {
        return nbKilometres;
    }

    public void setNbKilometres(Integer nbKilometres) {
        this.nbKilometres = nbKilometres;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "nom='" + nom + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                '}';
    }
}
