package certus.edu.pe.controladores.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	        .allowedOrigins("http://localhost:4200")
	        .allowedMethods("GET", "POST", "PUT", "DELETE")
	        .allowedHeaders("Origin", "Content-Type", "Accept", "Access-Control-Allow-Headers", "Access-Control-Allow-Methods")
	        .allowCredentials(true)
	        .maxAge(3600);
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("principal");
		registry.addViewController("/principal").setViewName("principal");
		registry.addViewController("/home").setViewName("principal");
		registry.addViewController("/inicio").setViewName("principal");
		registry.addViewController("/logeo").setViewName("index");
		registry.addViewController("/login").setViewName("index");
		registry.addViewController("/bienvenida").setViewName("bienvenida");
		registry.addViewController("/error").setViewName("error");
	}	
}
