package ProjectWebServices.WebServices.service;

import ProjectWebServices.WebServices.models.User;
import ProjectWebServices.WebServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/***
 * Klass som sköter databaskommunikationen som en mellanhand för UserController och UserRepository. Här hamnar
 * alla data innan den skickas till databasen och innan den skickas från databasen.
 * Alla metoder (CRUD - create, readOne, readAll, Update, Delete) kommunicerar med MySQL
 */
@Service
public class UserService implements UserDetailsService {
    //mellanhand mellan Controller och Repository. Enda klass som tar en Repository och sköter
    //databaskommunikationen. Hämtar data, validerar och returnerar till controller.
    //Innan datan skickas till databas och innan data skickas från databas

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    /***
     * Tar in id från User som man söker där userRepository använder findById för att söka i databasen.
     * @param id
     * @return antingen den hittade Usern, felmeddelandena 204 = "No content" eller 400 = "Bad Request"
     */
    public ResponseEntity<Optional<User>> selectOneUser(Long id) {
        try {
            if(userRepository.existsById(id)) {
                return ResponseEntity.ok(userRepository.findById(id));
            } else {
                return ResponseEntity.status(204).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    /***
     * Metod som hämtar alla Users i databasen med kontroll om listan är tom. Ifall det sistnämnda så får man
     * felmeddelandet 204 = "No Content" eller om något går fel, en 400 = "Bad Request".
     * @return
     */
    public ResponseEntity<List<User>> selectAllUsers(){
        try {
            List<User> users = userRepository.findAll();
            if(users.isEmpty()) {
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.ok(users);
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    /***
     * Metod som tar in User-id och en den nya Usern.
     * Kontrollerar först så att den sökta Usern(som skall uppdateras) finns. Om den gör det så sparas den
     * uppdaterade Usern i databasen via UserRepository annars får man ett felmeddelande.
     * @param id
     * @param user
     * @return
     */
    public ResponseEntity<User> updateUser(Long id, User user) {
        try {
            User updateUser = userRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Could not find user"));
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            return ResponseEntity.ok(userRepository.save(updateUser));
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    /***
     * Tar in id på den User som skall raderas. Först görs en koll för att den hårdkodade admin inte tas bort.
     * Därefter kollar man så att en User med matchande ID finns och den tas isåfall bort.
     * I övriga fall får man ett felmeddelande.
     * @param id
     * @return
     */
    public ResponseEntity<String> deleteUser(Long id) {
        if(id == 1) {
            return ResponseEntity.status(400).body("Admin can't be deleted!");
        }
        try {
            if(userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return ResponseEntity.ok("User was deleted");
            } else {
                return ResponseEntity.status(400).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepository.findByUsername(username).orElseThrow(() ->
                    new UsernameNotFoundException("User not valid"));
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not valid");
        }
    }
}
