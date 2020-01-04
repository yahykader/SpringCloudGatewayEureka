package kader.org.FacturationService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kader.org.FacturationService.model.Personne;

/**
 * @author abdel
 * ACCEDER A UNE AUTRE SERVICE EN UTILISANT API FEIGN CLIENT D UNE MANIERE DECLARATIVE
 */
@FeignClient(name="customer-service")
public interface CustomerServiceClient {
	
	@GetMapping(value="/personnes/{id}?projection=fullPersonne")
	Personne findPersonneByID(@PathVariable("id") Long id);
	
	

}
