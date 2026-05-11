package ma.enset.yazid.essoktani.exam.dtos;


import lombok.Data;
import ma.enset.yazid.essoktani.exam.enums.BoiteVitesse;
import ma.enset.yazid.essoktani.exam.enums.TypeCarburant;

@Data
public class VoitureDTO extends VehiculeDTO {
    private int nombrePortes;
    private TypeCarburant typeCarburant;
    private BoiteVitesse boiteVitesse;
}