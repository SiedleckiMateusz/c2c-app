package siedlecki.mateusz.c2capp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.client.Coordinates;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.service.client.ClientService;
import siedlecki.mateusz.c2capp.service.client.CoordinatesService;
import siedlecki.mateusz.c2capp.service.client.RouteService;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadData implements CommandLineRunner {

    private final ClientService clientService;
    private final RouteService routeService;
    private final CoordinatesService coordinatesService;

    public LoadData(ClientService clientService, RouteService routeService, CoordinatesService coordinatesService) {

        this.clientService = clientService;
        this.routeService = routeService;
        this.coordinatesService = coordinatesService;
    }

    @Override
    public void run(String... args) throws Exception {
        createSomeClientsWithRouteAndCoordinates();
    }

    public void createSomeClientsWithRouteAndCoordinates(){
        Route lublin = new Route("Lublin",new ArrayList<>());
        Route pulawy = new Route("Puławy",new ArrayList<>());
        Route krasnik = new Route("Krasnik",new ArrayList<>());
        Route chelm = new Route("Chełm",new ArrayList<>());
        Route leczna = new Route("Łęczna",new ArrayList<>());

        routeService.save(lublin);
        routeService.save(pulawy);
        routeService.save(krasnik);
        routeService.save(chelm);
        routeService.save(leczna);
//
//
//        Client lhKonwaliowa = Client.builder()
//                .warehouseName("LH KONWALIOWA")
//                .realName("Minuta 8")
//                .nip("9462640744")
//                .info("Stajemy przy drodze. Towar nosimy do tylnego wejscia")
//                .address("Konwaliowa 7, 20-258 Turka")
//                .build();
//
//        lublin.getClient().add(lhKonwaliowa);
//        lhKonwaliowa.setRoute(lublin);
//
//        Coordinates lhKonwaliowaCoordinates = new Coordinates("51.274476", "22.666250", lhKonwaliowa);
//
//        coordinatesService.save(lhKonwaliowaCoordinates);
//
//        lhKonwaliowa.setCoordinates(lhKonwaliowaCoordinates);
//
//        clientService.save(lhKonwaliowa);


        Client biuromix = Client.builder()
                .warehouseName("Biuromix Łęczna")
                .realName("Sklep z art. papierniczymi Biuromix")
                .nip("7132688698")
                .info("Wejscie od fruntu budynku")
                .address("Partyzancka 3, 21-010 Łęczna")
                .build();

        lublin.getClient().add(biuromix);
        biuromix.setRoute(leczna);



        Coordinates biuromixCoordinates = new Coordinates("51.305546", "22.881868");

        biuromixCoordinates.setClient(biuromix);

        biuromix.setCoordinates(biuromixCoordinates);


        clientService.save(biuromix);

        System.out.println(biuromix);
        System.out.println();









        List<Client> clients = clientService.findAll();

        clients.forEach(System.out::println);

    }


}
