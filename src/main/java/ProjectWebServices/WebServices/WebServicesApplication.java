package ProjectWebServices.WebServices;

import ProjectWebServices.WebServices.models.Role;
import ProjectWebServices.WebServices.models.User;
import ProjectWebServices.WebServices.repository.RoleRepository;
import ProjectWebServices.WebServices.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WebServicesApplication {

	/**
	 * 1. En databas med sånger
	 * 2. Vem som helst ska kunna komma åt "add, selectOne och selectAll"
	 * 3. Men bara en specifik ska kunna komma åt "Update och Delete"
	 */

	public static void main(String[] args) {
		SpringApplication.run(WebServicesApplication.class, args);
	}

	/***
	 * Ett interface som startar ett callback för att exekvera kod innan applicationen startar.
	 * I detta fallet skapar den de roller som krävs för att syftet med appen skall fungera som den ör tänkt.
	 * @param roleRep
	 * @param userRep
	 * @param encoder
	 * @return
	 */
	@Bean
	CommandLineRunner run(RoleRepository roleRep, UserRepository userRep, PasswordEncoder encoder) {
		return args -> {
			if(roleRep.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRep.save(new Role("ADMIN"));
			roleRep.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			User admin = new User(1,"admin", encoder.encode("password"), roles);
			userRep.save(admin);
		};
	}
}
