package ProjectWebServices.WebServices.repository;

import ProjectWebServices.WebServices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//12-03 -> @
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //12-03
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username); //????
}
