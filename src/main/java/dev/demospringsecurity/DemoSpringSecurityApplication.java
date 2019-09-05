package dev.demospringsecurity;

import dev.demospringsecurity.entities.Utilisateur;
import dev.demospringsecurity.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoSpringSecurityApplication {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		// insertion de 2 utilisateurs en base de données
		// Chiffrage des mots de passe avant insertion en base de données
		utilisateurRepository.save(new Utilisateur("u1", passwordEncoder.encode("pass1"), Arrays.asList("ROLE_ADMIN",
				"ROLE_USER")));
		utilisateurRepository.save(new Utilisateur("u2",  passwordEncoder.encode("pass2"), Arrays.asList("ROLE_USER")));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringSecurityApplication.class, args);
	}

}
