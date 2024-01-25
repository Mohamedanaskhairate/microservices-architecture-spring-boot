package org.sid.coproprietaire_service.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDateTime;
@Data
public class Lot {
    private Long id;


    private LocalDateTime creationDate;


    private String code;


    private String titreFoncier;


    private double tantieme;


    private Double tantiemeCommun;


    private String type;


    private String numLot;


    private Integer surfaceCadastrale;


    private double soldeInitiale;


    private double soldeCourant;


    private Boolean isDeleted;


    private Double soldePromoteur;


    private Double soldePromoteurInitial;


    private Boolean calculeExclu;


    private Boolean isArchived;

    private Long copropriete_id ;
    private Long coproprietaire_id;
}
