package kader.org.FacturationService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kader.org.FacturationService.model.Product;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryServiceClient {
	
	@GetMapping(value="/products/{id}")
	Product findProductById(@PathVariable(name="id") Long id); 
	
	@GetMapping(value="/products")
	PagedModel<Product> findAllProducts();

}
