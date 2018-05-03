package pl.artur.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.google.gson.Gson;

@SpringBootApplication
@PropertySource("application.properties")
@EnableScheduling
@EnableAsync
public class SpringMyBatisModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMyBatisModuleApplication.class, args);
	}
	
	@Bean
	public Gson getGson() {
		return new Gson();
	}
}
