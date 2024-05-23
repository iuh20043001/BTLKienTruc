package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("vn.edu.iuh.fit.models") // Chỉ định rõ thư mục chứa entity
@EnableJpaRepositories("vn.edu.iuh.fit.repositories")
public class DkhpApplication {
	public static void main(String[] args) {
		SpringApplication.run(DkhpApplication.class, args);
	}



}
