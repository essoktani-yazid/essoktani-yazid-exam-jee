package ma.enset.yazid.essoktani.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.yazid.essoktani.exam.enums.TypeMoto;

@Entity
@DiscriminatorValue("MOTO")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Moto extends Vehicule {
    private int cylindree;

    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;

    private boolean casqueInclus;
}