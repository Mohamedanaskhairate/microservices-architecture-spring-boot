package org.sid.coproprietaire_service.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.coproprietaire_service.model.Lot;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "coproprietaire")
public class Coproprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate= LocalDateTime.now();;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "nom")
    private String nom;

    @Column(name = "cin")
    private String cin;

    @Column(name = "ice")
    private Long ice;

    @Column(name = "titre_foncier", columnDefinition = "LONGTEXT")
    private String titreFoncier;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "telephone2")
    private String telephone2;

    @Column(name = "email")
    private String email;

    @Column(name = "email2")
    private String email2;

    @Column(name = "rib")
    private String rib;

    @Column(name = "ville")
    private String ville;

    @Column(name = "adresse", columnDefinition = "LONGTEXT")
    private String adresse;

    @Column(name = "is_promoteur")
    private Boolean isPromoteur;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "is_archived")
    private Boolean isArchived;

    @Transient
    private Long lot_id;
    @Transient
    private Lot lot;
}
