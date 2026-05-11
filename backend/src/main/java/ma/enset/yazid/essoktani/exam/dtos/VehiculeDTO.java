package ma.enset.yazid.essoktani.exam.dtos;


import lombok.Data;
import ma.enset.yazid.essoktani.exam.enums.StatutVehicule;

import java.util.Date;

@Data
public class VehiculeDTO {
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;
    private Date dateMiseEnService;
    private StatutVehicule statut;
    private String type; // Pour distinguer Voiture/Moto dans le Frontend
}