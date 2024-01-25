package org.sid.copropriete_service.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.copropriete_service.enums.Statut_Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "copropriete")
public class Copropriete {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonProperty("id")
    private Long id;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Column(name = "pseudonyme", nullable = false, length = 50)
    private String pseudonyme;
    @Column(name = "statut", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Statut_Type statut;
    @Column(name = "type", nullable = false, length = 10)
    private String type;
    @Column(name = "ville", nullable = false, length = 50)
    private String ville;
    @Lob
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "nbr_lots", nullable = false)
    private Integer nbrLots;
    @Lob
    @Column(name = "titre_fonciers_mere")
    private String titreFonciersMere;
    @Column(name = "nouvellement_livree", nullable = false)
    private Boolean nouvellementLivree;
    @Column(name = "solde_reserve", nullable = false)
    private Double soldeReserve;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "copropriete_mere_id")
    private Copropriete coproprieteMere;
    @Column(name = "code_commercant")
    private Long codeCommercant;
    @Column(name = "cle_secrete", length = 50)
    private String cleSecrete;
    @Column(name = "id_galerie", length = 50)
    private String idGalerie;

    @Lob
    @Column(name = "image")
    private byte[] image;
  //  @Transient
    //@JsonIgnore
    @OneToMany(mappedBy = "copropriete")

    private Collection<CompteBancaire> compteBancaires ;
}
