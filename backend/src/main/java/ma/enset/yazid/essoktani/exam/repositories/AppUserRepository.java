package ma.enset.yazid.essoktani.exam.repositories;

import ma.enset.yazid.essoktani.exam.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
