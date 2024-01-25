package org.sid.lot_service.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.lot_service.enums.Type_Solde;
import org.sid.lot_service.model.Coproprietaire;
import org.sid.lot_service.model.Copropriete;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "lot")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "titre_foncier", nullable = false)
    private String titreFoncier;

    @Column(name = "tantieme", nullable = false)
    private double tantieme;

    @Column(name = "tantieme_commun")
    private Double tantiemeCommun;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "num_lot")
    private String numLot;

    @Column(name = "surface_cadastrale")
    private Integer surfaceCadastrale;

    @Column(name = "solde_initiale", nullable = false)
    private double soldeInitiale;

    @Column(name = "solde_courant", nullable = false)
    private double soldeCourant;
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;
    @Column(name = "solde_promoteur")
    private Double soldePromoteur;
    @Column(name = "solde_promoteur_initial")
    private Double soldePromoteurInitial;
    @Column(name = "calcule_exclu")
    private Boolean calculeExclu;
    @Column(name = "is_archived")
    private Boolean isArchived;
     @Column (name = "copropriete_id")
     private Long copropriete_id ;
     @Transient
    private Copropriete copropriete ;

     @Column (name = "coproprietaire_id")
     private Long coproprietaire_id;
    @Transient
    private Coproprietaire coproprietaire;
   @OneToMany(mappedBy = "lot")
    private Collection <Relever> relever ;
    public double getSoldeCourant() {
        // Vérifier si la collection de relevés est vide
        if (relever.isEmpty()) {
            return 0;
        }
        // Calculer la somme des montants en fonction du type des relevés
        double sommeDebit = relever.stream()
                .filter(relever -> Type_Solde.DEBIT.equals(relever.getType()))
                .mapToDouble(Relever::getMontant)
                .sum();

        double sommeCredit = relever.stream()
                .filter(relever -> Type_Solde.CREDIT.equals(relever.getType()))
                .mapToDouble(Relever::getMontant)
                .sum();
        return sommeDebit - sommeCredit;
    }
}
