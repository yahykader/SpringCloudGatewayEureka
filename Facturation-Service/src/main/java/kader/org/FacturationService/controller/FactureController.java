package kader.org.FacturationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kader.org.FacturationService.feignClient.CustomerServiceClient;
import kader.org.FacturationService.feignClient.InventoryServiceClient;
import kader.org.FacturationService.model.Facture;
import kader.org.FacturationService.repository.FactureRepository;
import kader.org.FacturationService.repository.ProductItemRepository;

@RestController
public class FactureController {
	
	@Autowired
	private FactureRepository factureRepository;
	@Autowired 
	private ProductItemRepository productItemRepository;
	@Autowired
	private CustomerServiceClient customerServiceClient;
	@Autowired
	private InventoryServiceClient inventoryServiceClient;
	
	@GetMapping(value="/factures/full/{id}")
	public Facture getFacture(@PathVariable("id") Long id) {
		Facture facture=factureRepository.findById(id).get();
		facture.setCustomer(customerServiceClient.findPersonneByID(facture.getPersonneId()));
		facture.setProductItems(productItemRepository.findByFactureId(id));
		facture.getProductItems().forEach(pi->{
			
		    pi.setProduct(inventoryServiceClient.findProductById(pi.getProductId()));
		});
		
		return facture;
	}

}
