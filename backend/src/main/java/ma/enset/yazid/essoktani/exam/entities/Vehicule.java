package ma.enset.yazid.essoktani.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.yazid.essoktani.exam.enums.StatutVehicule;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;

    private Date dateMiseEnService;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne
    private Agence agence;

    @OneToMany(mappedBy = "vehicule")
    private List<Location> locations;
}