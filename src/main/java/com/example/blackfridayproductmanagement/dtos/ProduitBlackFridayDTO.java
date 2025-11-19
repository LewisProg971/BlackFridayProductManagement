package com.example.blackfridayproductmanagement.dtos;

import com.example.blackfridayproductmanagement.enumeration.TypeProduit;

import java.math.BigDecimal;

public class ProduitBlackFridayDTO {
    private Long id;
    private String nom;
    private TypeProduit type;
    private BigDecimal prixInitial;
    private BigDecimal prixFinal;

    // Constructeur
    public ProduitBlackFridayDTO(Long id, String nom, TypeProduit type, BigDecimal prixInitial, BigDecimal prixFinal) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.prixInitial = prixInitial;
        this.prixFinal = prixFinal;
    }

    public ProduitBlackFridayDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeProduit getType() {
        return type;
    }

    public void setType(TypeProduit type) {
        this.type = type;
    }

    public BigDecimal getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(BigDecimal prixInitial) {
        this.prixInitial = prixInitial;
    }

    public BigDecimal getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(BigDecimal prixFinal) {
        this.prixFinal = prixFinal;
    }
}
