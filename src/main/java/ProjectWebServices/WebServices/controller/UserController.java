package ProjectWebServices.WebServices.controller;

import ProjectWebServices.WebServices.entity.User;
import ProjectWebServices.WebServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//SKickar data till databas anropar Serviceklass
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("//")
    public String helloUserController() {
        return "Hello user access";
    }

    //Lägger till och sparar användare i databasen
    @PostMapping("")
    public String saveUser(
            @RequestBody User user
    ) {
        //Spara user i DB
        User newUser = userService.saveUser(user);

        return String.format("New user with username \"%s\" and ID \"%d\" created", newUser.getUsername(), newUser.getId());
    }

    @GetMapping("")
    private String getAllUsers() {
        List<User> users = userService.selectAllUsers();

        //Hämtar namnen på alla användare
        String response = "Namnen på alla users är: ";
        for (User user : users) {
            response += user.getUsername() + "\n";
        }
        return response;
    }
}
