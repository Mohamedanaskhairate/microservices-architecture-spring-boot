package org.sid.lot_service.repository;

import org.sid.lot_service.entities.Lot;
import org.sid.lot_service.entities.Relever;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LotRepository extends JpaRepository<Lot,Long> {

}
