package ProjectWebServices.WebServices.service;

import ProjectWebServices.WebServices.entity.User;
import ProjectWebServices.WebServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService { //mellanhand mellan Controller och Repository. Enda klass som tar en Repository och sköter
    //databaskommunikationen. Hämtar data, validerar och returnerar till controller.
    //Innan datan skickas till databas och innan data skickas från databas

    @Autowired
    private UserRepository userRepository;
    public User saveUser(
            @PathVariable User user
    ) {

        //Verifiering av data som kommer in och sparas i databasen
        //Krypteringsmetod för lösenord
       return userRepository.save(user);
    }

    //Metod som returnerar alla användare från databas
    public List<User> selectAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    //Metod som returnerar en användare från databas
    public User selectOneUser(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            return user.get();
        } catch (NoSuchElementException) {
            return new User();
        }
    }



}
