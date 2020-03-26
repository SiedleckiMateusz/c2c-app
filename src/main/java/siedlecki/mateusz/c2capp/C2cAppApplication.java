package siedlecki.mateusz.c2capp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import siedlecki.mateusz.c2capp.service.client.ClientService;

@SpringBootApplication
public class C2cAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(C2cAppApplication.class, args);

    }

}
