package ma.enset.yazid.essoktani.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.yazid.essoktani.exam.enums.BoiteVitesse;
import ma.enset.yazid.essoktani.exam.enums.TypeCarburant;

@Entity
@DiscriminatorValue("VOITURE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Voiture extends Vehicule {
    private int nombrePortes;

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;
}