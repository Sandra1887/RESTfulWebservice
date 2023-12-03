package ProjectWebServices.WebServices.controller;

import ProjectWebServices.WebServices.entity.User;
import ProjectWebServices.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//SKickar data till databas anropar Serviceklass
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/")
    public String helloUserController() {
        return "Hello user access";
    }*/

    //Lägger till och sparar användare i databasen
    /*@PostMapping("")
    public ResponseEntity<User> createUser(
            @RequestBody User user
    ) {
        return ResponseEntity.ok(userService.saveUser(user));
    }*/

    //Hämtar en sång med ID
    @GetMapping("/selectone/{id}")
    public ResponseEntity<Optional<User>> selectOneUser(
            @PathVariable Long id
    ) {
        return userService.selectOneUser(id);
    }

    //Hämtar alla sånger
    @GetMapping("/selectall")
    public ResponseEntity<List<User>> selectAllUsers() {
        try {
            return userService.selectAllUsers();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
        /*
        //Hämtar namnen på alla användare
        String response = "Namnen på alla users är: ";
        for (User user : users) {
            response += user.getUsername() + "\n";
        }
        return response;*/
    }

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}
