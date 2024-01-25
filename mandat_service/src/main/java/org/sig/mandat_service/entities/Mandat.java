package org.sig.mandat_service.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sig.mandat_service.model.Copropriete;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "mandat")
public class Mandat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "code")
    private String code;
    @Column(name = "statut")
    private String statut;
    @Column(name = "date_demarrage")
    private LocalDateTime dateDemarrage;
    @Column(name = "date_cloture")
    private LocalDateTime dateCloture;
    @Column(name = "duree_mois")
    private Integer dureeMois;
    @Column(name = "honoraire_annuels_tcc")
    private Double honorairesAnnuelsTCC;
    @Column(name = "copropriete_id")
    private Long copropriete_id;
    @Transient
    private Copropriete copropriete ;
}
