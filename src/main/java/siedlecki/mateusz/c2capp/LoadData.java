package siedlecki.mateusz.c2capp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.service.client.ClientService;
import siedlecki.mateusz.c2capp.service.client.RouteService;

import java.util.List;

@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {

    private final ClientService clientService;
    private final RouteService routeService;

    public LoadData(ClientService clientService, RouteService routeService) {

        this.clientService = clientService;
        this.routeService = routeService;
    }

    public void createSomeClients(){
        Client mateusz = Client.builder()
                .warehouseName("Mateoo")
                .realName("Mateusz Siedlecki")
                .nip("312-41-32-543")
                .info("Nie wiem co powiedzieć")
                .address("Dożynkowa 21d/11")
                .build();

        Route route1 = new Route();

        route1.setName("Lublin");
        route1.getClient().add(mateusz);
        mateusz.setRoute(route1);

        routeService.save(route1);


        Client saveBackClient = clientService.save(mateusz);


        List<Client> clients = clientService.findAll();

        clients.forEach(System.out::println);
        System.out.println("Id: "+saveBackClient.getId());


    }


    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createSomeClients();
    }
}
