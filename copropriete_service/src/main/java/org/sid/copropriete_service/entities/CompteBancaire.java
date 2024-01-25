package org.sid.copropriete_service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "compte_bancaire")
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();


    @Column(name = "adresse_banque")
    private String adresseBanque;

    @Column(name = "code_swift")
    private String codeSwift;

    @Column(name = "type_signataire")
    private String typeSignataire;

    @Column(name = "code_banque")
    private String codeBanque;

    @Column(name = "ville")
    private String ville;

    @Column(name = "num_compte")
    private String numCompte;

    @Column(name = "cle_rib")
    private String cleRib;

    @Column(name = "nom")
    private String nom;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "lien")
    private String lien;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "solde_initiale")
    private Double soldeInitiale;

    @Column(name = "solde_courant")
    private Double soldeCourant;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "copropriete_id")
  //  @JsonManagedReference
    private Copropriete copropriete;

    //public void setCopropriete(Copropriete copropriete) {
        //this.copropriete = copropriete;
    //


   //public Long getCoproprieteId() {
        //return copropriete != null ? copropriete.getId() : null;
   // }
}
