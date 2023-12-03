package ProjectWebServices.WebServices.controller;

import ProjectWebServices.WebServices.models.User;
import ProjectWebServices.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private UserService userService;

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
