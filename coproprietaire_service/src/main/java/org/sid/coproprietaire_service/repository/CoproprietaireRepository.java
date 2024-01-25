package org.sid.coproprietaire_service.repository;

import org.sid.coproprietaire_service.entities.Coproprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoproprietaireRepository extends JpaRepository<Coproprietaire,Long> {

}
