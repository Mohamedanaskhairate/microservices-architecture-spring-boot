package org.sig.mandat_service.controller;

import org.sig.mandat_service.entities.Mandat;
import org.sig.mandat_service.feign.CoproprieteRestClient;
import org.sig.mandat_service.model.Copropriete;
import org.sig.mandat_service.repository.MandatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mandats")
public class MandatController {
    @Autowired
    MandatRepository mandatRepository ;
    @Autowired
    CoproprieteRestClient coproprieteRestClient ;

    @GetMapping("/consulter/{id}")
    public Mandat getMandat(@PathVariable Long id) {
        Mandat mandat = mandatRepository.findById(id).orElse(null);
        if (mandat != null) {
            Copropriete copropriete = coproprieteRestClient.getCoproprieteById(mandat.getCopropriete_id());
            mandat.setCopropriete(copropriete);
        }
        return mandat;
    }
}
