package com.example.blackfridayproductmanagement.entities;

import com.example.blackfridayproductmanagement.enumeration.TypeProduit;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 25]

    private String nomCommercial; // [cite: 26]

    @Enumerated(EnumType.STRING)
    private TypeProduit type; // [cite: 27]

    private BigDecimal prixAchat; // [cite: 28]
    private BigDecimal prixVenteInitial; // [cite: 29]
    private String description; // [cite: 30]

    // Constructeurs, Getters et Setters (Génère-les avec IntelliJ : Alt+Insert)
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
