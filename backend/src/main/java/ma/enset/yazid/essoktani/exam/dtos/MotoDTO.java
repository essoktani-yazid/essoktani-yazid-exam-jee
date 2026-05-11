package ma.enset.yazid.essoktani.exam.dtos;

import lombok.Data;
import ma.enset.yazid.essoktani.exam.enums.TypeMoto;

@Data
public class MotoDTO extends VehiculeDTO {
    private int cylindree;
    private TypeMoto typeMoto;
    private boolean casqueInclus;
}