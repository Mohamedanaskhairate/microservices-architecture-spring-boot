package org.sid.copropriete_service.services;

import org.sid.copropriete_service.entities.CompteBancaire;
import org.sid.copropriete_service.entities.Copropriete;
import org.sid.copropriete_service.repository.CompteBancaireRepository;
import org.sid.copropriete_service.repository.CoproprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompteBancaireservice {
   private final CompteBancaireRepository compteBancaireRepository;
    private final CoproprieteRepository coproprieteRepository;
    @Autowired
    public CompteBancaireservice(CompteBancaireRepository compteBancaireRepository, CoproprieteRepository coproprieteRepository) {
       this.compteBancaireRepository = compteBancaireRepository;
        this.coproprieteRepository = coproprieteRepository;
    }
  //  private CompteBancaireRepository compteBancaireRepository;
    public List<CompteBancaire> rechercheParNumCompte(String numCompte){
        return compteBancaireRepository.findByNumCompte(numCompte);
    }
    public List<CompteBancaire> rechercheParNom(String nom){
        return  compteBancaireRepository.findByNom(nom);
    }
    public CompteBancaire ajouterCompteBancaire(CompteBancaire compteBancaire, Long coproprieteId) {
        Copropriete copropriete = coproprieteRepository.findById(coproprieteId).orElse(null);
        if (copropriete != null) {
            compteBancaire.setCopropriete(copropriete);
            return compteBancaireRepository.save(compteBancaire);
        }
        return null; // Gérer le cas où la copropriété n'est pas trouvée
    }
    public List<CompteBancaire> getComptesBancairesByCoproprieteId(Long coproprieteId) {
        return compteBancaireRepository.findByCoproprieteId(coproprieteId);
    }

}