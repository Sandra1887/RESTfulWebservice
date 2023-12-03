package ProjectWebServices.WebServices.service;

import ProjectWebServices.WebServices.entity.Role;
import ProjectWebServices.WebServices.entity.User;
import ProjectWebServices.WebServices.repository.UserRepository;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    //mellanhand mellan Controller och Repository. Enda klass som tar en Repository och sköter
    //databaskommunikationen. Hämtar data, validerar och returnerar till controller.
    //Innan datan skickas till databas och innan data skickas från databas

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder; //hash the password

    //private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    /*public User saveUser(
            @PathVariable User user
    ) {
       return userRepository.save(user);
    }*/

    public ResponseEntity<Optional<User>> selectOneUser(Long id) {
        try {
            if(userRepository.existsById(id)) {
                //logger.info("User found");
                return ResponseEntity.ok(userRepository.findById(id));
            } else {
                //logger.info("Could not find User");
                return ResponseEntity.status(204).build();
            }
        } catch (Exception e) {
            //logger.info("Error getting User");
            return ResponseEntity.status(400).build();
        }
    }

    //Metod som returnerar alla användare från databas
    public ResponseEntity<List<User>> selectAllUsers(){
        try {
            List<User> users = userRepository.findAll();
            if(users.isEmpty()) {
                //logger.info("Could not find Users");
                return ResponseEntity.status(204).build();
            } else {
                //logger.info("Users found: ");
                return ResponseEntity.ok(users);
            }
        } catch (Exception e) {
            //logger.info("Error getting Users");
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<User> updateUser(Long id, User user) {
        try {
            User updateUser = userRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Could not find user"));
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            //logger.info("User updated");
            return ResponseEntity.ok(userRepository.save(updateUser));
        } catch (Exception e) {
            //logger.info("Error updating User");
            return ResponseEntity.status(400).build();
        }
    }

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
            //logger.info("Error deleting user");
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
