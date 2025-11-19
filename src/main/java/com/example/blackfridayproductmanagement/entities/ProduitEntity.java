package com.example.blackfridayproductmanagement.entities;

import com.example.blackfridayproductmanagement.enumeration.TypeProduit;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomCommercial;

    @Enumerated(EnumType.STRING)
    private TypeProduit type;

    private BigDecimal prixAchat;
    private BigDecimal prixVenteInitial;
    private String description;


    public void Produit() {}

    public void Produit(String nomCommercial, TypeProduit type, BigDecimal prixAchat, BigDecimal prixVenteInitial, String description) {
        this.nomCommercial = nomCommercial;
        this.type = type;
        this.prixAchat = prixAchat;
        this.prixVenteInitial = prixVenteInitial;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public TypeProduit getType() {
        return type;
    }

    public void setType(TypeProduit type) {
        this.type = type;
    }

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public BigDecimal getPrixVenteInitial() {
        return prixVenteInitial;
    }

    public void setPrixVenteInitial(BigDecimal prixVenteInitial) {
        this.prixVenteInitial = prixVenteInitial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
