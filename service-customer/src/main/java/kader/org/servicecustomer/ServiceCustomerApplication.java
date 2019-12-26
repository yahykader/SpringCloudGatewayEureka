package kader.org.servicecustomer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Entity
class Personne{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public Personne(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String toString() {
		   return "Customer " + this.id +
			  " : name " + this.name +
			  ", email " + this.email;
		}
}
@RepositoryRestResource
interface PersonneRepository extends JpaRepository<Personne, Long>{}

/*
 * @RestController class PersonneController{
 * 
 * @Autowired private PersonneRepository personneRepository;
 * 
 * @GetMapping(value="/personnes") public List<Personne> AllPersonnes(){ return
 * personneRepository.findAll(); }
 * 
 * }
 */
@SpringBootApplication
public class ServiceCustomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(PersonneRepository customerRepository) {
		return args->{
		customerRepository.save(new Personne(null,"kader","kader@gmail.com")); 
		customerRepository.save(new Personne(null,"nesrine","nesrine@gmail.com")); 
		customerRepository.findAll().forEach(System.out::println);	
		};	
	}
}
