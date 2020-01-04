package kader.org.FacturationService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kader.org.FacturationService.model.Facture;
import kader.org.FacturationService.model.ProductItem;
import kader.org.FacturationService.repository.FactureRepository;
import kader.org.FacturationService.repository.ProductItemRepository;

@SpringBootApplication
public class FacturationServiceApplication implements CommandLineRunner {
	
	@Autowired 
	private ProductItemRepository productItemRepository;
	@Autowired
	private FactureRepository factureRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FacturationServiceApplication.class, args);
	}
   
	
	@Override
	public void run(String... args) throws Exception {
		Facture f=factureRepository.save(new Facture(null,new Date(),1L,null,null));
		
		productItemRepository.save(new ProductItem(null,1L,null,80,147,f));
		productItemRepository.save(new ProductItem(null,2L,null,80,147,f));
		productItemRepository.save(new ProductItem(null,3L,null,80,147,f));
		
	}

}
