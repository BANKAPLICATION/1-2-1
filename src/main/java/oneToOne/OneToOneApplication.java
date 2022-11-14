package oneToOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class OneToOneApplication {
    public static void main(String[] args) {
        System.out.println("localdatetime = " + LocalDateTime.now());
        SpringApplication.run(OneToOneApplication.class, args);
    }
}
