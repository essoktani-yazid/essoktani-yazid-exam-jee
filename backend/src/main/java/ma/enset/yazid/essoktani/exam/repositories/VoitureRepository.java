package ma.enset.yazid.essoktani.exam.repositories;

import ma.enset.yazid.essoktani.exam.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> { }