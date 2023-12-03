package ProjectWebServices.WebServices.controller;

import ProjectWebServices.WebServices.models.User;
import ProjectWebServices.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/***
 * Controller class with "admin" base-url-endpoint med en instans av UserService som den skickar och tar emot data
 * ifrån. Kommunicerar via API och Postman genom de olika endpoints som i sin tur är kopplade till
 * metoder i UserService.
 */

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private UserService userService;

    /***
     * Hämtar User med sökt id från metoden i UserService
     * @param id
     * @return
     */
    @GetMapping("/selectone/{id}")
    public ResponseEntity<Optional<User>> selectOneUser(
            @PathVariable Long id
    ) {
        return userService.selectOneUser(id);
    }

    /***
     * Hämtar alla users från metoden i UserService
     * @return antingen en lista av alla Users eller ett bad request-felmeddelande.
     */
    @GetMapping("/selectall")
    public ResponseEntity<List<User>> selectAllUsers() {
        try {
            return userService.selectAllUsers();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /***
     * Skickar id till metoden i UserService
     * @param id
     * @param user
     * @return den uppdaterade usern eller ett bad-request-felmeddelande
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {
        try {
            return userService.updateUser(id, user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /***
     * Raderar User som är kopplad till inskickat ID
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}
