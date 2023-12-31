package ProjectWebServices.WebServices.repository;

import ProjectWebServices.WebServices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 * Sköter kommunikationen med databasen med hjälp av JpaRepository och agerar i sin tur mellanhand för UserService
 * och AuthenticationService.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
