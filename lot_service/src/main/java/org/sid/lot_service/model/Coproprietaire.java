package org.sid.lot_service.model;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class Coproprietaire {
    private Long id;
    private LocalDateTime creationDate;
    private String code;
    private String type;
    private String nom;
    private String cin;
    private Long ice;
    private String titreFoncier;
    private String telephone;
    private String telephone2;
    private String email;
    private String email2;
    private String rib;
    private String ville;
    private String adresse;
    private Boolean isPromoteur;
    private Boolean isDeleted;
    private Boolean isArchived;

}
