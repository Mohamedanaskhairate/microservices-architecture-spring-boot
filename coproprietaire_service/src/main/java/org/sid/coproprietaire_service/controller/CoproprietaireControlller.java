package org.sid.coproprietaire_service.controller;

import org.sid.coproprietaire_service.entities.Coproprietaire;
import org.sid.coproprietaire_service.feign.LotRestClient;
import org.sid.coproprietaire_service.model.Lot;
import org.sid.coproprietaire_service.repository.CoproprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coproprietaire")
public class CoproprietaireControlller {
    @Autowired
    CoproprietaireRepository coproprietaireRepository;

    @Autowired
    LotRestClient lotRestClient;

    @GetMapping("/consulter/{id}")
    public Coproprietaire getCoproprietaire(@PathVariable Long id) {
        Coproprietaire coproprietaire = coproprietaireRepository.findById(id).orElse(null);
        if (coproprietaire != null) {
            Lot lot = lotRestClient.getLotById(coproprietaire.getLot_id());
            coproprietaire.setLot(lot);
        }
        return coproprietaire;
    }
}
