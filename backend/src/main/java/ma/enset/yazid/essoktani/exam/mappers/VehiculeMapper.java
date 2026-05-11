package ma.enset.yazid.essoktani.exam.mappers;

import ma.enset.yazid.essoktani.exam.dtos.AgenceDTO;
import ma.enset.yazid.essoktani.exam.dtos.LocationDTO;
import ma.enset.yazid.essoktani.exam.dtos.MotoDTO;
import ma.enset.yazid.essoktani.exam.dtos.VoitureDTO;
import ma.enset.yazid.essoktani.exam.entities.Agence;
import ma.enset.yazid.essoktani.exam.entities.Location;
import ma.enset.yazid.essoktani.exam.entities.Moto;
import ma.enset.yazid.essoktani.exam.entities.Voiture;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VehiculeMapper {

    public AgenceDTO fromAgence(Agence agence) {
        AgenceDTO agenceDTO = new AgenceDTO();
        BeanUtils.copyProperties(agence, agenceDTO);
        return agenceDTO;
    }

    public Agence fromAgenceDTO(AgenceDTO agenceDTO) {
        Agence agence = new Agence();
        BeanUtils.copyProperties(agenceDTO, agence);
        return agence;
    }

    public VoitureDTO fromVoiture(Voiture voiture) {
        VoitureDTO voitureDTO = new VoitureDTO();
        BeanUtils.copyProperties(voiture, voitureDTO);
        voitureDTO.setType("Voiture");
        return voitureDTO;
    }

    public Voiture fromVoitureDTO(VoitureDTO voitureDTO) {
        Voiture voiture = new Voiture();
        BeanUtils.copyProperties(voitureDTO, voiture);
        return voiture;
    }

    public MotoDTO fromMoto(Moto moto) {
        MotoDTO motoDTO = new MotoDTO();
        BeanUtils.copyProperties(moto, motoDTO);
        motoDTO.setType("Moto");
        return motoDTO;
    }

    public Moto fromMotoDTO(MotoDTO motoDTO) {
        Moto moto = new Moto();
        BeanUtils.copyProperties(motoDTO, moto);
        return moto;
    }

    public LocationDTO fromLocation(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        BeanUtils.copyProperties(location, locationDTO);

        if (location.getVehicule() != null) {
            if (location.getVehicule() instanceof Voiture) {
                locationDTO.setVehicule(fromVoiture((Voiture) location.getVehicule()));
            } else if (location.getVehicule() instanceof Moto) {
                locationDTO.setVehicule(fromMoto((Moto) location.getVehicule()));
            }
        }
        return locationDTO;
    }

    public Location fromLocationDTO(LocationDTO locationDTO) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDTO, location);

        if (locationDTO.getVehicule() != null) {
            if (locationDTO.getVehicule() instanceof VoitureDTO) {
                location.setVehicule(fromVoitureDTO((VoitureDTO) locationDTO.getVehicule()));
            } else if (locationDTO.getVehicule() instanceof MotoDTO) {
                location.setVehicule(fromMotoDTO((MotoDTO) locationDTO.getVehicule()));
            }
        }
        return location;
    }
}