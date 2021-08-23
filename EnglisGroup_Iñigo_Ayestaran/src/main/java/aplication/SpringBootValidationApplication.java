package aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.CampService;
import service.SummerCampServiceImpl;
import validator.PostalCodeValidation;
import validator.PersonValidation;

@SpringBootApplication
public class SpringBootValidationApplication implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
	}

	@Bean
	public PersonValidation registrationValidation() {
		return new PersonValidation();
	}
	
	@Bean
	public PostalCodeValidation postalCodeValidation() {
		return new PostalCodeValidation();
	}
	
	@Bean
	public CampService summerCampService() {
		return new SummerCampServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootValidationApplication.class, args);
	}

}
