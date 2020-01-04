package kader.org.FacturationService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kader.org.FacturationService.model.Product;

@FeignClient(name="inventory-service")
public interface InventoryServiceClient {
	
	@GetMapping(value="/products/{id}?projection=fullProduct")
	Product findProductById(@PathVariable("id") Long id); 
	
	@GetMapping(value="/products?projection=fullProduct")
	PagedModel<Product> findAll();

}
