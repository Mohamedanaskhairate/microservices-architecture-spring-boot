package org.sid.lot_service.controller;

import org.sid.lot_service.entities.Lot;
import org.sid.lot_service.feign.CoproprietaireRestClient;
import org.sid.lot_service.feign.CoproprieteRestClient;
import org.sid.lot_service.model.Coproprietaire;
import org.sid.lot_service.model.Copropriete;
import org.sid.lot_service.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping("/lots")
public class LotController {
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private CoproprietaireRestClient coproprietaireRestClient;
    @Autowired
    private CoproprieteRestClient coproprieteRestClient;
    @GetMapping("/consulter/{id}")
    public Lot getLot(@PathVariable Long id) {
        Lot lot = lotRepository.findById(id).orElse(null);
        if (lot != null) {
            Copropriete copropriete = coproprieteRestClient.getCoproprieteById(lot.getCopropriete_id());
            lot.setCopropriete(copropriete);

            Coproprietaire coproprietaire = coproprietaireRestClient.getCoproprietaireById(lot.getCoproprietaire_id());
            lot.setCoproprietaire(coproprietaire);
        }
        return lot;
    }
}


