package org.sig.mandat_service.repository;
import org.sig.mandat_service.entities.Mandat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MandatRepository extends JpaRepository <Mandat,Long> {

}
