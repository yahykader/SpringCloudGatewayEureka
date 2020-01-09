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
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
}
@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer, Long>{}

/*
 * @RestController class PersonneController{
 * 
 * @Autowired private CustomerRepository customerRepository;
 * 
 * @GetMapping(value="/customers") public List<Customer> AllCustomers(){ return
 * personneRepository.findAll(); }
 * 
 * }
 */
@SpringBootApplication
public class ServiceCustomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomerApplication.class, args);
	}
	@Autowired
    private RepositoryRestConfiguration restConfiguration;
	@Bean
	CommandLineRunner run(CustomerRepository customerRepository) {
		return args->{
			restConfiguration.exposeIdsFor(Customer.class);
		customerRepository.save(new Customer(null,"kader","kader@gmail.com")); 
		customerRepository.save(new Customer(null,"nesrine","nesrine@gmail.com")); 
		customerRepository.findAll().forEach(System.out::println);	
		};	
	}
}
