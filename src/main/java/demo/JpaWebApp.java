package demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//Configuration
//EnableAutoConfiguration
//ComponentScan
@SpringBootApplication
public class JpaWebApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JpaWebApp.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JpaWebApp.class, args);
	}

}
