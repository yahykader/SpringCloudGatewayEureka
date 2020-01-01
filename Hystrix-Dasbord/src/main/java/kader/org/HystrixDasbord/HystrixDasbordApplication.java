package kader.org.HystrixDasbord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDasbordApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDasbordApplication.class, args);
	}

}
