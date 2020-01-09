package kader.org.FacturationService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kader.org.FacturationService.model.Customer;


/**
 * @author abdel
 * ACCEDER A UNE AUTRE SERVICE EN UTILISANT API FEIGN CLIENT D UNE MANIERE DECLARATIVE
 */
@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceClient {
	
	@GetMapping(value="/customers/{id}")
	Customer findCustomerByID(@PathVariable(name="id") Long id);
	
	

}
