package pl.artur.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
public class SpringMyBatisModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMyBatisModuleApplication.class, args);
	}
}
