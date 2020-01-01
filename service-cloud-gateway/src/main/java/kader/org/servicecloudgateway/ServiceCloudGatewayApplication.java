package kader.org.servicecloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author abdel
 *
 */
@SpringBootApplication
public class ServiceCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCloudGatewayApplication.class, args);
	}
	/**
	 * @author abdel
	 * @Configuration Route Gateway Static 
	 */	
	/*@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				  .route(r->r.path("/personnes/**").uri("http://localhost:8081/").id("r1"))
				  .route(r->r.path("/products/**").uri("http://localhost:8082/").id("r2"))
				  .build();
	}*/
    
	/*@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				  .route(r->r.path("/personnes/**").uri("lb://CUSTOMER-SERVICE").id("r1"))
				  .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE").id("r2"))
				  .build();
	}*/
	
	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				/**
				 * @param builder Gateway Static RapidApi RestCountries
				 * @return Path + Filters(addRequestHeader+rewritePath)+Uri+Id
				 */
				  .route(r->r.path("/restcountries/**")
				  .filters(f->f.addRequestHeader("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
						       .addRequestHeader("x-rapidapi-key","547aeacdc1mshb5463482bd57bb6p1c7f41jsn18e619801876")
						       .rewritePath("/restcountries/(?<segment>.*)", "/${segment}"))
				  .uri("https://restcountries-v1.p.rapidapi.com").id("countries"))
				  
				  
				  
				  .route(r->r.path("/currency-exchange/**")
						  .filters(f->f.addRequestHeader("x-rapidapi-host","currency-exchange.p.rapidapi.com")
								       .addRequestHeader("x-rapidapi-key","547aeacdc1mshb5463482bd57bb6p1c7f41jsn18e619801876")
								       .rewritePath("/currency-exchange/(?<segment>.*)", "/${segment}"))
						  .uri("https://currency-exchange.p.rapidapi.com").id("currency-exchange"))
				  .build();
	}
	/**
	 * @author abdel
	 * @Configuration Route Gateway Dynamic 
	 */
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
	
}
