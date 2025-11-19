package com.example.blackfridayproductmanagement.repositories;

import com.example.blackfridayproductmanagement.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {
    // JpaRepository fournit déjà save(), findById(), deleteById(), findAll()
}
