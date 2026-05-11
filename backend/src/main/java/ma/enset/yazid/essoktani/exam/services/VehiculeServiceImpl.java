package ma.enset.yazid.essoktani.exam.services;


import lombok.AllArgsConstructor;
import ma.enset.yazid.essoktani.exam.dtos.*;
import ma.enset.yazid.essoktani.exam.entities.*;
import ma.enset.yazid.essoktani.exam.mappers.VehiculeMapper;
import ma.enset.yazid.essoktani.exam.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {
    private AgenceRepository agenceRepository;
    private VehiculeRepository vehiculeRepository;
    private VehiculeMapper dtoMapper;

    @Override
    public AgenceDTO saveAgence(AgenceDTO agenceDTO) {
        Agence agence = dtoMapper.fromAgenceDTO(agenceDTO);
        return dtoMapper.fromAgence(agenceRepository.save(agence));
    }

    @Override
    public VoitureDTO saveVoiture(VoitureDTO voitureDTO) {
        Voiture voiture = dtoMapper.fromVoitureDTO(voitureDTO);
        return dtoMapper.fromVoiture(vehiculeRepository.save(voiture));
    }

    @Override
    public MotoDTO saveMoto(MotoDTO motoDTO) {
        Moto moto = dtoMapper.fromMotoDTO(motoDTO);
        return dtoMapper.fromMoto(vehiculeRepository.save(moto));
    }

    @Override
    public List<VehiculeDTO> listVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        return vehicules.stream().map(v -> {
            if (v instanceof Voiture) return dtoMapper.fromVoiture((Voiture) v);
            else return dtoMapper.fromMoto((Moto) v);
        }).collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO getVehicule(Long id) {
        Vehicule v = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouvé"));
        if (v instanceof Voiture) return dtoMapper.fromVoiture((Voiture) v);
        return dtoMapper.fromMoto((Moto) v);
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public List<AgenceDTO> listAgences() {
        return agenceRepository.findAll().stream()
                .map(dtoMapper::fromAgence)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO louerVehicule(Long vehiculeId, Date dateDebut, Date dateFin) {
        return null;
    }
}