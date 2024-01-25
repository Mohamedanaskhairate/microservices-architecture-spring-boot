package org.sid.copropriete_service.repository;
import org.sid.copropriete_service.entities.Copropriete;
import org.sid.copropriete_service.enums.Statut_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CoproprieteRepository extends JpaRepository<Copropriete, Long> {

    List<Copropriete> findByNom(String nom);
    List<Copropriete> findByVille(String ville);
    List<Copropriete> findByStatut(Statut_Type statut);

}
