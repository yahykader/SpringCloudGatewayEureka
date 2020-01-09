package kader.org.serviceinventory;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;

}
@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product, Long>{}
@SpringBootApplication
public class ServiceInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceInventoryApplication.class, args);
	}
	@Autowired
    private RepositoryRestConfiguration restConfiguration;
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args->{
			restConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"Imprimante",1254));
			productRepository.save(new Product(null,"Ordinateur",1254));
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
