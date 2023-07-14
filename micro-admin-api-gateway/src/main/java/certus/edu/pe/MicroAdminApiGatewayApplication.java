package certus.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroAdminApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAdminApiGatewayApplication.class, args);
	}

}
