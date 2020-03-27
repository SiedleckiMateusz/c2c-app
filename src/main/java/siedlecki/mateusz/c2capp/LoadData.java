package siedlecki.mateusz.c2capp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.client.Coordinates;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.model.employee.Department;
import siedlecki.mateusz.c2capp.model.employee.Employee;
import siedlecki.mateusz.c2capp.model.employee.WorkPosition;
import siedlecki.mateusz.c2capp.service.client.ClientService;
import siedlecki.mateusz.c2capp.service.client.RouteService;
import siedlecki.mateusz.c2capp.service.employee.DepartmentService;
import siedlecki.mateusz.c2capp.service.employee.EmployeeSerivce;
import siedlecki.mateusz.c2capp.service.employee.WorkPositionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadData implements CommandLineRunner {

    private final ClientService clientService;
    private final RouteService routeService;

    private final EmployeeSerivce employeeSerivce;
    private final DepartmentService departmentService;
    private final WorkPositionService workPositionService;

    public LoadData(ClientService clientService, RouteService routeService, EmployeeSerivce employeeSerivce, DepartmentService departmentService, WorkPositionService workPositionService) {

        this.clientService = clientService;
        this.routeService = routeService;
        this.employeeSerivce = employeeSerivce;
        this.departmentService = departmentService;
        this.workPositionService = workPositionService;
    }

    @Override
    public void run(String... args) {
        createClientsWithRouteAndCoordinates();
        createDeliveriesWithDealerAndSupplier();
        createEmployeeWithDepartmentAndWorkPosition();
    }

    public void createClientsWithRouteAndCoordinates(){
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


        Client lhKonwaliowa = Client.builder()
                .warehouseName("LH KONWALIOWA")
                .realName("Minuta 8")
                .nip("9462640744")
                .info("Stajemy przy drodze. Towar nosimy do tylnego wejscia")
                .address("Konwaliowa 7, 20-258 Turka")
                .build();

        lublin.getClient().add(lhKonwaliowa);
        lhKonwaliowa.setRoute(lublin);

        Coordinates lhKonwaliowaCoordinates = new Coordinates("51.274476", "22.666250");

        lhKonwaliowaCoordinates.setClient(lhKonwaliowa);

        lhKonwaliowa.setCoordinates(lhKonwaliowaCoordinates);

        clientService.save(lhKonwaliowa);


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




        Client kominek = Client.builder()
                .warehouseName("KOMINEK")
                .realName("Restauracja Kominek")
                .nip("7162696389")
                .info("Glowne wejscie, na lewo schody w dol. Towar stawiamy przy lodowkach")
                .address("Wojska Polskiego 8B, 24-100 Pulawy")
                .build();

        lublin.getClient().add(kominek);
        kominek.setRoute(leczna);



        Coordinates kominekCoordinates = new Coordinates("51.417314", "21.975474");

        kominekCoordinates.setClient(kominek);

        kominek.setCoordinates(kominekCoordinates);


        clientService.save(kominek);

        Client ph1 = Client.builder()
                .warehouseName("PH1")
                .realName("Sklep Gamma")
                .nip("5632423737")
                .info("Podjezdzamy od tylu pod rampe, ukladamy towar na paletach i wprowadzamy palety do srodka. Dziewczyny sprawdzaja, a po podpis idziemy waskim korytarzem do biura po lewej stronie")
                .address("al. Piłsudskiego 26, 22-100 Chełm")
                .build();

        lublin.getClient().add(ph1);
        ph1.setRoute(leczna);

        Coordinates ph1Coordinates = new Coordinates("51.138164", "23.495130",ph1);

        ph1.setCoordinates(ph1Coordinates);

        clientService.save(ph1);


        List<Client> clients = clientService.findAll();

        clients.forEach(System.out::println);

    }

    public void createEmployeeWithDepartmentAndWorkPosition(){
        Department magazyn = new Department("Magazyn");
        Department biuro = new Department("Biuro");
        Department handlowy = new Department("Handlowy");
        Department fabryka = new Department("Fabryka");
        Department zarzad = new Department("Zarząd");

        departmentService.saveAll(Arrays.asList(magazyn,biuro,handlowy,fabryka,zarzad));
        departmentService.findAll().forEach(System.out::println);

        WorkPosition magazynier = new WorkPosition("Pracownik magazynu","Pracownik magazynu");
        WorkPosition kierowca = new WorkPosition("Kierowca","Kierowca");
        WorkPosition kierownik = new WorkPosition("Kierownik","Kierownik");
        WorkPosition zastepcaKierownika = new WorkPosition("Zastępca kierownika","Zastępca kierownika");
        WorkPosition przedstawicielHandlowy = new WorkPosition("Przedstawiciel handlowy","Przedstawiciel handlowy");
        WorkPosition prezes = new WorkPosition("Prezes","Prezes");
        WorkPosition admin = new WorkPosition("Administrator aplikacji","Administrator aplikacji");

        workPositionService.saveAll(Arrays.asList(magazynier,kierowca,kierownik,zastepcaKierownika,przedstawicielHandlowy,prezes,admin));
        workPositionService.findAll().forEach(System.out::println);

        Employee mateusz = Employee.builder()
                .firstName("Mateusz")
                .lastName("Siedlecki")
                .login("msiedlecki")
                .password("1234")
                .email("siedleckimateus@gmail.com")
                .phoneNumber("722045780")
                .department(magazyn)
                .workPosition(admin)
                .build();

        System.out.println(employeeSerivce.save(mateusz));


    }

    public void createDeliveriesWithDealerAndSupplier(){

    }


}
