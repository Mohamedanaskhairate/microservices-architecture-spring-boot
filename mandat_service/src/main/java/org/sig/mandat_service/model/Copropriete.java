package org.sig.mandat_service.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Copropriete {
    private Long id;
    private LocalDateTime creationDate;
    private String code;
    private String nom;
    private String pseudonyme;
    private String statut;
    private String type;
    private String ville;
    private String adresse;
    private Integer nbrLots;
    private String titreFonciersMere;
    private Boolean nouvellementLivree;
    private Double soldeReserve;
    private Copropriete coproprieteMere;
    private Long codeCommercant;
    private String cleSecrete;
    private String idGalerie;
    private Boolean isDeleted;
    private byte[] image;
}

