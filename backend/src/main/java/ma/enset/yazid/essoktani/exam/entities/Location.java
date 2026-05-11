package ma.enset.yazid.essoktani.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private double montantTotal;

    @ManyToOne
    private Vehicule vehicule;
}