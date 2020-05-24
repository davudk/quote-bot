package dk.njit.cs684.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "local");
        SpringApplication.run(Application.class, args);
    }
}
