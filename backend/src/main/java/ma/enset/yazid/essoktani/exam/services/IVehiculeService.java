package ma.enset.yazid.essoktani.exam.services;

import ma.enset.yazid.essoktani.exam.dtos.*;

import java.util.Date;
import java.util.List;

public interface IVehiculeService {
    AgenceDTO saveAgence(AgenceDTO agenceDTO);
    VoitureDTO saveVoiture(VoitureDTO voitureDTO);
    MotoDTO saveMoto(MotoDTO motoDTO);
    List<VehiculeDTO> listVehicules();
    VehiculeDTO getVehicule(Long id);
    void deleteVehicule(Long id);
    List<AgenceDTO> listAgences();
    LocationDTO louerVehicule(Long vehiculeId, Date dateDebut, Date dateFin);
}