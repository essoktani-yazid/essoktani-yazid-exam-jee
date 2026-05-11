package ma.enset.yazid.essoktani.exam;

import ma.enset.yazid.essoktani.exam.dtos.AgenceDTO;
import ma.enset.yazid.essoktani.exam.dtos.VehiculeDTO;
import ma.enset.yazid.essoktani.exam.dtos.VoitureDTO;
import ma.enset.yazid.essoktani.exam.entities.Agence;
import ma.enset.yazid.essoktani.exam.entities.Location;
import ma.enset.yazid.essoktani.exam.entities.Moto;
import ma.enset.yazid.essoktani.exam.entities.Voiture;
import ma.enset.yazid.essoktani.exam.enums.BoiteVitesse;
import ma.enset.yazid.essoktani.exam.enums.StatutVehicule;
import ma.enset.yazid.essoktani.exam.enums.TypeCarburant;
import ma.enset.yazid.essoktani.exam.enums.TypeMoto;
import ma.enset.yazid.essoktani.exam.repositories.AgenceRepository;
import ma.enset.yazid.essoktani.exam.repositories.LocationRepository;
import ma.enset.yazid.essoktani.exam.repositories.VehiculeRepository;
import ma.enset.yazid.essoktani.exam.services.IVehiculeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

//    @Bean
    CommandLineRunner testService(IVehiculeService vehiculeService) {
        return args -> {
            System.out.println("=========================================");
            System.out.println("Début du test de la couche Service...");

            AgenceDTO agenceDTO = new AgenceDTO();
            agenceDTO.setNom("Global Auto");
            agenceDTO.setVille("Mohammedia");
            agenceDTO.setAdresse("Centre ville");
            agenceDTO.setTelephone("0500112233");

            AgenceDTO savedAgence = vehiculeService.saveAgence(agenceDTO);
            System.out.println("Agence sauvegardée avec ID : " + savedAgence.getId());

            VoitureDTO voitureDTO = new VoitureDTO();
            voitureDTO.setMarque("Renault");
            voitureDTO.setModele("Clio 5");
            voitureDTO.setMatricule("1111-A-1");
            voitureDTO.setPrixParJour(300.0);
            voitureDTO.setDateMiseEnService(new Date());
            voitureDTO.setStatut(StatutVehicule.DISPONIBLE);
            voitureDTO.setNombrePortes(5);
            voitureDTO.setTypeCarburant(TypeCarburant.DIESEL);
            voitureDTO.setBoiteVitesse(BoiteVitesse.MANUELLE);

            VoitureDTO savedVoiture = vehiculeService.saveVoiture(voitureDTO);
            System.out.println("Voiture sauvegardée, type reçu : " + savedVoiture.getType());

            System.out.println("--- Liste des véhicules ---");
            List<VehiculeDTO> vehicules = vehiculeService.listVehicules();
            vehicules.forEach(v -> {
                System.out.println("- " + v.getMarque() + " " + v.getModele() + " (Type: " + v.getType() + ")");
            });

            System.out.println("Test de la couche Service terminé avec succès !");
            System.out.println("=========================================");
        };
    }

    @Bean
    CommandLineRunner start(AgenceRepository agenceRepository,
                            VehiculeRepository vehiculeRepository,
                            LocationRepository locationRepository) {
        return args -> {

            Agence agence1 = Agence.builder()
                    .nom("Casa Auto Rent")
                    .ville("Casablanca")
                    .adresse("123 Bd Anfa")
                    .telephone("0522000000")
                    .build();
            agenceRepository.save(agence1);

            Voiture voiture = new Voiture();
            voiture.setMarque("Dacia");
            voiture.setModele("Logan");
            voiture.setMatricule("9899-A-1");
            voiture.setPrixParJour(250.0);
            voiture.setDateMiseEnService(new Date());
            voiture.setStatut(StatutVehicule.DISPONIBLE);
            voiture.setNombrePortes(5);
            voiture.setTypeCarburant(TypeCarburant.DIESEL);
            voiture.setBoiteVitesse(BoiteVitesse.MANUELLE);
            voiture.setAgence(agence1);
            vehiculeRepository.save(voiture);

            Moto moto = new Moto();
            moto.setMarque("Yamaha");
            moto.setModele("TMAX");
            moto.setMatricule("6788-B-6");
            moto.setPrixParJour(400.0);
            moto.setDateMiseEnService(new Date());
            moto.setStatut(StatutVehicule.DISPONIBLE);
            moto.setCylindree(560);
            moto.setTypeMoto(TypeMoto.SCOOTER);
            moto.setCasqueInclus(true);
            moto.setAgence(agence1);
            vehiculeRepository.save(moto);

            Location location = Location.builder()
                    .dateDebut(new Date())
                    .dateFin(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 3)))
                    .montantTotal(750.0)
                    .vehicule(voiture)
                    .build();
            locationRepository.save(location);

            System.out.println("Base de données initialisée avec succès !");
        };
    }

}
