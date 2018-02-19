package ma.cndh.openpms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OpenpmsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OpenpmsApplication.class, args);
		
	}
}
