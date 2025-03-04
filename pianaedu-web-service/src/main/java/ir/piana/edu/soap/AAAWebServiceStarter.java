package ir.piana.edu.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "ir.piana.edu.soap"})
public class AAAWebServiceStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AAAWebServiceStarter.class, args);
	}
}
