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
	/**
	 * @author abdel
	 * @Configuration Route Gateway Dynamic 
	 */
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
	
}
