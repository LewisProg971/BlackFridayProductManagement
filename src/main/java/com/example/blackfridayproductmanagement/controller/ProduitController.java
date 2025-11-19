package com.example.blackfridayproductmanagement.controller;

import com.example.blackfridayproductmanagement.dtos.ProduitBlackFridayDTO;
import com.example.blackfridayproductmanagement.entities.ProduitEntity;
import com.example.blackfridayproductmanagement.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService service;


    @PostMapping
    public ProduitEntity creer(@RequestBody ProduitEntity produit) {
        return service.creerProduit(produit);
    }


    @GetMapping("/{id}")
    public ProduitEntity recuperer(@PathVariable Long id) {
        return service.recupererProduit(id);
    }


    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimerProduit(id);
    }


    @GetMapping("/blackfriday")
    public List<ProduitBlackFridayDTO> getBlackFridayOffers() {
        return service.getProduitsBlackFriday();
    }

}

