package flower.flowercontinue.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT * FROM user u WHERE u.email = ?1")
    Optional<AppUser> findAppUserByEmail(String email);
}
