package ma.enset.yazid.essoktani.exam.web;

import lombok.AllArgsConstructor;
import ma.enset.yazid.essoktani.exam.dtos.MotoDTO;
import ma.enset.yazid.essoktani.exam.dtos.VehiculeDTO;
import ma.enset.yazid.essoktani.exam.dtos.VoitureDTO;
import ma.enset.yazid.essoktani.exam.services.IVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class VehiculeRestController {
    private IVehiculeService vehiculeService;

    @GetMapping("/vehicules")
    public List<VehiculeDTO> getAllVehicules() {
        return vehiculeService.listVehicules();
    }

    @GetMapping("/vehicules/{id}")
    public VehiculeDTO getVehicule(@PathVariable Long id) {
        return vehiculeService.getVehicule(id);
    }

    @PostMapping("/vehicules/voitures")
    public VoitureDTO saveVoiture(@RequestBody VoitureDTO voitureDTO) {
        return vehiculeService.saveVoiture(voitureDTO);
    }

    @PostMapping("/vehicules/motos")
    public MotoDTO saveMoto(@RequestBody MotoDTO motoDTO) {
        return vehiculeService.saveMoto(motoDTO);
    }

    @DeleteMapping("/vehicules/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }
}