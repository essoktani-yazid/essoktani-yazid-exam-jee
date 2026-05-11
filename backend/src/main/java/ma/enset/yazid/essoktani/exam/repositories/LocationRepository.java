package ma.enset.yazid.essoktani.exam.repositories;

import ma.enset.yazid.essoktani.exam.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> { }