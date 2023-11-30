package ProjectWebServices.WebServices.repository;

import ProjectWebServices.WebServices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
