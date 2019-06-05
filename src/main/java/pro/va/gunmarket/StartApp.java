package pro.va.gunmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pro.va.gunmarket.*")
public class StartApp {

	public static void main(String[] args) {
		SpringApplication.run(StartApp.class);
	}

}
