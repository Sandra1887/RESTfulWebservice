package ProjectWebServices.WebServices.controller;

import ProjectWebServices.WebServices.dto.LoginResponseDTO;
import ProjectWebServices.WebServices.dto.RegistrationDTO;
import ProjectWebServices.WebServices.models.User;
import ProjectWebServices.WebServices.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * Controllerklass med basen "/auth" för authentication endpoints "/register" och "/login" och som kommunicerar
 * med AuthenticationService som hanterar metoder för inloggning och registrering av User.
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
