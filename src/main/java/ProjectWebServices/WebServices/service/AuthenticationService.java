package ProjectWebServices.WebServices.service;

import ProjectWebServices.WebServices.dto.LoginResponseDTO;
import ProjectWebServices.WebServices.models.Role;
import ProjectWebServices.WebServices.models.User;
import ProjectWebServices.WebServices.repository.RoleRepository;
import ProjectWebServices.WebServices.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional //spring manages transactions between the database and application
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<User> registerUser(String username, String password) {
        try {
            String encodedPassword = passwordEncoder.encode(password);
            Role userRole = roleRepository.findByAuthority("USER").get();

            Set<Role> authorities = new HashSet<>();
            authorities.add(userRole);

            return ResponseEntity.ok(userRepository.save(new User(0, username, encodedPassword, authorities)));

        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    public ResponseEntity<LoginResponseDTO> loginUser(String username, String password) {
        try {
            if(!userRepository.existsByUsername(username)) return ResponseEntity.status(400).build();

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            String token = tokenService.generateJwt(auth);
            return ResponseEntity.ok(new LoginResponseDTO(userRepository.findByUsername(username).get(), token));
        } catch (Exception e) {
            return ResponseEntity.status(401).build();

        }
    }
}
