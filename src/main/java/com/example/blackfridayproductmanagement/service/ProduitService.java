package com.example.blackfridayproductmanagement.service;

import com.example.blackfridayproductmanagement.dtos.ProduitBlackFridayDTO;
import com.example.blackfridayproductmanagement.entities.ProduitEntity;
import com.example.blackfridayproductmanagement.enumeration.TypeProduit;
import com.example.blackfridayproductmanagement.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository repository;

    // CRUD Basiques
    public ProduitEntity creerProduit(ProduitEntity p) {
        return repository.save(p);
    }

    public ProduitEntity recupererProduit(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    public void supprimerProduit(Long id) {
        repository.deleteById(id);
    }

    // Logique Black Friday [cite: 38]
    public List<ProduitBlackFridayDTO> getProduitsBlackFriday() {
        List<ProduitEntity> produits = repository.findAll();

        return produits.stream().map(p -> {
            BigDecimal remise = getPourcentageRemise(p.getType());
            // Formule : Prix - (Prix * Remise)
            BigDecimal montantRemise = p.getPrixVenteInitial().multiply(remise);
            BigDecimal prixFinal = p.getPrixVenteInitial().subtract(montantRemise);

            // Arrondi à 2 décimales
            prixFinal = prixFinal.setScale(2, RoundingMode.HALF_UP);

            return new ProduitBlackFridayDTO(
                    p.getId(),
                    p.getNomCommercial(),
                    p.getType(),
                    p.getPrixVenteInitial(),
                    prixFinal
            );
        }).collect(Collectors.toList());
    }

    private BigDecimal getPourcentageRemise(TypeProduit type) {
        // Définition des remises [cite: 40]
        switch (type) {
            case HIGH_TECH: return new BigDecimal("0.15");
            case LIVRE: return new BigDecimal("0.30");
            case MODE: return new BigDecimal("0.40");
            case ELECTROMENAGER: return new BigDecimal("0.20");
            default: return new BigDecimal("0.10");
        }
    }
}
