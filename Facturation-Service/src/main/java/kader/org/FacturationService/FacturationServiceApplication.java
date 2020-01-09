package kader.org.FacturationService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.hateoas.PagedModel;

import kader.org.FacturationService.feignClient.CustomerServiceClient;
import kader.org.FacturationService.feignClient.InventoryServiceClient;
import kader.org.FacturationService.model.Customer;
import kader.org.FacturationService.model.Facture;
import kader.org.FacturationService.model.Product;
import kader.org.FacturationService.model.ProductItem;
import kader.org.FacturationService.repository.FactureRepository;
import kader.org.FacturationService.repository.ProductItemRepository;

@SpringBootApplication
@EnableFeignClients
public class FacturationServiceApplication implements CommandLineRunner {
	
	@Autowired 
	private ProductItemRepository productItemRepository;
	@Autowired
	private FactureRepository factureRepository;
	@Autowired
    private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private CustomerServiceClient customerServiceClient;
	@Autowired
	private InventoryServiceClient inventoryServiceClient;
	

	public static void main(String[] args) {
		SpringApplication.run(FacturationServiceApplication.class, args);
	}
   
	
	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Facture.class);
		Customer c1=customerServiceClient.findCustomerByID(1L);
		Customer c2=customerServiceClient.findCustomerByID(2L);
		System.out.println("*****************************");
		System.out.println("*****"+c1.getId());
		System.out.println("*****"+c1.getName());
		System.out.println("*****"+c1.getEmail());
		System.out.println("*****************************");
		Facture f=factureRepository.save(new Facture(null,new Date(),c1.getId(),null,null));
		Facture f2=factureRepository.save(new Facture(null,new Date(),c2.getId(),null,null));
		PagedModel<Product> products=inventoryServiceClient.findAllProducts();
		System.out.println("*****************************");
		products.getContent().forEach(p->{
			productItemRepository.save(new ProductItem(null,p.getId(),null,p.getPrice(),147,f));
			productItemRepository.save(new ProductItem(null,p.getId(),null,p.getPrice(),147,f2));
		});
		
	}

}
