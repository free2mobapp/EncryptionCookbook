package uk.co.ksb.EncryptionCookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EncryptionCookbookApplication {

	@Autowired
	private EmployerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EncryptionCookbookApplication.class, args);
	}

	@PostConstruct
	public void loadData() {

			repository.save((new Employer(1, "Bhasker", "Srini")));
			repository.save((new Employer(2, "Sudha", "Srini")));
			repository.save((new Employer(3, "Vidhula", "Barad")));
	}
}
