package org.sid.copropriete_service.controllers;


import org.sid.copropriete_service.entities.CompteBancaire;
import org.sid.copropriete_service.services.CompteBancaireservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteBancaireController {
    @Autowired
    private CompteBancaireservice compteBancaireservice ;
    @GetMapping("/compteBancaires/rechercheParNumCompte")
    public List<CompteBancaire> rechercheParNumCompte(@RequestParam("numCompte") String numCompte){
        return compteBancaireservice.rechercheParNumCompte(numCompte);
    }
    @GetMapping("/compteBancaires/rechercheParNom")
    public List<CompteBancaire> rechercheParNom(@RequestParam("nom") String nom){
        return compteBancaireservice.rechercheParNom(nom);
    }
    @PostMapping("/coproprietes/{coproprieteId}/compteBancaires")
    public CompteBancaire ajouterCompteBancaire(@PathVariable Long coproprieteId, @RequestBody CompteBancaire compteBancaire) {
        return compteBancaireservice.ajouterCompteBancaire(compteBancaire, coproprieteId);
    }
    @GetMapping("/coproprietes/{id}/compteBancaires")
    public List<CompteBancaire> getComptesBancaires(@PathVariable("id") Long coproprieteId) {
        return compteBancaireservice.getComptesBancairesByCoproprieteId(coproprieteId);
    }
}
