package org.sid.copropriete_service.repository;

import org.sid.copropriete_service.entities.CompteBancaire;
import org.sid.copropriete_service.entities.Copropriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire,Long> {
    List<CompteBancaire> findByNumCompte(String numCompte);
    List<CompteBancaire> findByNom(String nom);
    List<CompteBancaire> findByCoproprieteId(Long id);
}
