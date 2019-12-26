package kader.org.serviceinventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@Entity
class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}	
}
@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product, Long>{}
@SpringBootApplication
public class ServiceInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceInventoryApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args->{
			productRepository.save(new Product(null,"Imprimante",1254));
			productRepository.save(new Product(null,"Ordinateur",1254));
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
