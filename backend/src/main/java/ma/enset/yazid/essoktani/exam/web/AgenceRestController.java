package ma.enset.yazid.essoktani.exam.web;

import lombok.AllArgsConstructor;
import ma.enset.yazid.essoktani.exam.dtos.AgenceDTO;
import ma.enset.yazid.essoktani.exam.services.IVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class AgenceRestController {
    private IVehiculeService vehiculeService;

    @GetMapping("/agences")
    public List<AgenceDTO> getAgences() {
        return vehiculeService.listAgences();
    }

    @PostMapping("/agences")
    public AgenceDTO saveAgence(@RequestBody AgenceDTO agenceDTO) {
        return vehiculeService.saveAgence(agenceDTO);
    }
}