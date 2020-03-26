package siedlecki.mateusz.c2capp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.service.client.ClientService;

import java.util.List;

@Component
public class LoadData implements CommandLineRunner {

    private final ClientService clientService;

    public LoadData(ClientService clientService) {

        this.clientService = clientService;
    }

    public void createSomeClients(){
        Client mateusz = Client.builder()
                .id(1L)
                .warehouseName("Mateoo")
                .realName("Mateusz Siedlecki")
                .nip("312-41-32-543")
                .info("Nie wiem co powiedzieć")
                .address("Dożynkowa 21d/11")
                .build();

//        Route route1 = new Route();

//        route1.setName("Lublin");
//        route1.getClient().add(mateusz);
//        mateusz.setRoute(route1);


        clientService.save(mateusz);


        List<Client> clients = clientService.findAll();

        clients.forEach(System.out::println);


    }

    @Override
    public void run(String... args) throws Exception {
        createSomeClients();
    }
}
