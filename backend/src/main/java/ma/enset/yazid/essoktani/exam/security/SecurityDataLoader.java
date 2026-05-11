package ma.enset.yazid.essoktani.exam.security;

import lombok.RequiredArgsConstructor;
import ma.enset.yazid.essoktani.exam.entities.AppUser;
import ma.enset.yazid.essoktani.exam.enums.Role;
import ma.enset.yazid.essoktani.exam.repositories.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityDataLoader implements CommandLineRunner {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (appUserRepository.count() == 0) {
            AppUser admin = AppUser.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            AppUser employe = AppUser.builder()
                    .username("employe")
                    .password(passwordEncoder.encode("employe"))
                    .role(Role.ROLE_EMPLOYE)
                    .build();

            AppUser client = AppUser.builder()
                    .username("client")
                    .password(passwordEncoder.encode("client"))
                    .role(Role.ROLE_CLIENT)
                    .build();

            appUserRepository.save(admin);
            appUserRepository.save(employe);
            appUserRepository.save(client);
        }
    }
}
