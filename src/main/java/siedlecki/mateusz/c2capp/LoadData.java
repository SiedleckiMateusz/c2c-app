package siedlecki.mateusz.c2capp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.client.Coordinates;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.model.delivery.Dealer;
import siedlecki.mateusz.c2capp.model.delivery.Delivery;
import siedlecki.mateusz.c2capp.model.delivery.ProductInDelivery;
import siedlecki.mateusz.c2capp.model.delivery.Supplier;
import siedlecki.mateusz.c2capp.model.employee.Department;
import siedlecki.mateusz.c2capp.model.employee.Employee;
import siedlecki.mateusz.c2capp.model.employee.WorkPosition;
import siedlecki.mateusz.c2capp.model.product.Location;
import siedlecki.mateusz.c2capp.model.product.Product;
import siedlecki.mateusz.c2capp.model.product.ProductFlag;
import siedlecki.mateusz.c2capp.model.product.Unit;
import siedlecki.mateusz.c2capp.service.client.ClientService;
import siedlecki.mateusz.c2capp.service.client.RouteService;
import siedlecki.mateusz.c2capp.service.delivery.DealerService;
import siedlecki.mateusz.c2capp.service.delivery.DeliveryService;
import siedlecki.mateusz.c2capp.service.delivery.SupplierService;
import siedlecki.mateusz.c2capp.service.employee.DepartmentService;
import siedlecki.mateusz.c2capp.service.employee.EmployeeSerivce;
import siedlecki.mateusz.c2capp.service.employee.WorkPositionService;
import siedlecki.mateusz.c2capp.service.product.LocationService;
import siedlecki.mateusz.c2capp.service.product.ProductFlagService;
import siedlecki.mateusz.c2capp.service.product.ProductService;
import siedlecki.mateusz.c2capp.service.product.UnitService;

import java.time.LocalDateTime;
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

    private final LocationService locationService;
    private final ProductFlagService productFlagService;
    private final ProductService productService;


    private final UnitService unitService;
    private final DealerService dealerService;
    private final DeliveryService deliveryService;
    private final SupplierService supplierService;

    public LoadData(ClientService clientService, RouteService routeService, EmployeeSerivce employeeSerivce
            , DepartmentService departmentService, WorkPositionService workPositionService
            , LocationService locationService, ProductFlagService productFlagService
            , ProductService productService, UnitService unitService, DealerService dealerService
            , DeliveryService deliveryService, SupplierService supplierService) {

        this.clientService = clientService;
        this.routeService = routeService;
        this.employeeSerivce = employeeSerivce;
        this.departmentService = departmentService;
        this.workPositionService = workPositionService;
        this.locationService = locationService;
        this.productFlagService = productFlagService;
        this.productService = productService;
        this.unitService = unitService;
        this.dealerService = dealerService;
        this.deliveryService = deliveryService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) {
        createClients();
        createEmployee();
        createProducts();
        createDeliveries();
    }

    public void createClients(){
        Route lublin = new Route("Lublin",new ArrayList<>());
        Route pulawy = new Route("Puławy",new ArrayList<>());
        Route krasnik = new Route("Kraśnik",new ArrayList<>());
        Route chelm = new Route("Chełm",new ArrayList<>());
        Route leczna = new Route("Łęczna",new ArrayList<>());

        routeService.save(lublin);
        routeService.save(pulawy);
        routeService.save(krasnik);
        routeService.save(chelm);
        routeService.save(leczna);

        routeService.findAll().forEach(System.out::println);


        Coordinates lhKonwaliowaCoordinates = new Coordinates("51.274476", "22.666250");

        Client lhKonwaliowa = Client.builder()
                .warehouseName("LH KONWALIOWA")
                .realName("Minuta 8")
                .nip("9462640744")
                .info("Stajemy przy drodze. Towar nosimy do tylnego wejscia")
                .address("Konwaliowa 7, 20-258 Turka")
                .route(leczna)
                .coordinates(lhKonwaliowaCoordinates)
                .build();

        leczna.getClients().add(lhKonwaliowa);
        lhKonwaliowaCoordinates.setClient(lhKonwaliowa);

        clientService.save(lhKonwaliowa);


        Coordinates biuromixCoordinates = new Coordinates("51.305546", "22.881868");

        Client biuromix = Client.builder()
                .warehouseName("Biuromix Łęczna")
                .realName("Sklep z art. papierniczymi Biuromix")
                .nip("7132688698")
                .info("Wejscie od fruntu budynku")
                .address("Partyzancka 3, 21-010 Łęczna")
                .route(leczna)
                .coordinates(biuromixCoordinates)
                .build();

        lublin.getClients().add(biuromix);
        biuromixCoordinates.setClient(biuromix);

        clientService.save(biuromix);



        Coordinates kominekCoordinates = new Coordinates("51.417314", "21.975474");

        Client kominek = Client.builder()
                .warehouseName("KOMINEK")
                .realName("Restauracja Kominek")
                .nip("7162696389")
                .info("Glowne wejscie, na lewo schody w dol. Towar stawiamy przy lodowkach")
                .address("Wojska Polskiego 8B, 24-100 Pulawy")
                .route(pulawy)
                .coordinates(kominekCoordinates)
                .build();

        pulawy.getClients().add(kominek);
        kominekCoordinates.setClient(kominek);

        clientService.save(kominek);


        Coordinates ph1Coordinates = new Coordinates("51.138164", "23.495130");

        Client ph1 = Client.builder()
                .warehouseName("PH1")
                .realName("Sklep Gamma")
                .nip("5632423737")
                .info("Podjezdzamy od tylu pod rampe, ukladamy towar na paletach i wprowadzamy palety do srodka. Dziewczyny sprawdzaja, a po podpis idziemy waskim korytarzem do biura po lewej stronie")
                .address("al. Piłsudskiego 26, 22-100 Chełm")
                .route(chelm)
                .coordinates(ph1Coordinates)
                .build();

        lublin.getClients().add(ph1);
        ph1Coordinates.setClient(ph1);

        clientService.save(ph1);



        List<Client> clients = clientService.findAll();

        clients.forEach(System.out::println);

    }

    public void createEmployee(){
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
        WorkPosition pracownikBiurowy = new WorkPosition("Pracownik biurowy","Pracownik biurowy");
        WorkPosition prezes = new WorkPosition("Prezes","Prezes");
        WorkPosition admin = new WorkPosition("Administrator aplikacji","Administrator aplikacji");

        workPositionService.saveAll(Arrays.asList(magazynier,kierowca,kierownik,zastepcaKierownika,przedstawicielHandlowy,pracownikBiurowy,prezes,admin));
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

        employeeSerivce.save(mateusz);


        Employee piotrek = Employee.builder()
                .firstName("Piotrek")
                .lastName("Panasiuk")
                .login("ppanasiuk")
                .password("1234")
                .email("ppanasiuk@gmail.com")
                .phoneNumber("606606214")
                .department(magazyn)
                .workPosition(kierowca)
                .build();

        employeeSerivce.save(piotrek);

        Employee darek = Employee.builder()
                .firstName("Darek")
                .lastName("Cękała")
                .login("dcekala")
                .password("1234")
                .email("dcekala@gmail.com")
                .phoneNumber("532727772")
                .department(magazyn)
                .workPosition(kierownik)
                .build();

        employeeSerivce.save(darek);


        Employee sandra = Employee.builder()
                .firstName("Sandra")
                .lastName("Ignatiuk")
                .login("signatiuk")
                .password("1234")
                .email("signatiuk@gmail.com")
                .phoneNumber("500326234")
                .department(biuro)
                .workPosition(pracownikBiurowy)
                .build();

        employeeSerivce.save(sandra);


        Employee przemek = Employee.builder()
                .firstName("Przemysław")
                .lastName("Niedziałek")
                .login("pniedzialek")
                .password("1234")
                .email("pniedzialek@gmail.com")
                .phoneNumber("566347734")
                .department(handlowy)
                .workPosition(przedstawicielHandlowy)
                .build();

        employeeSerivce.save(przemek);



        employeeSerivce.findAll().forEach(System.out::println);


    }

    public void createProducts(){
        Location a1 = new Location("Alejka 1");
        Location a2 = new Location("Alejka 2");
        Location b1 = new Location("Blaszak 1");
        Location b2 = new Location("Blaszak 2");
        Location b3 = new Location("Blaszak 3");

        locationService.saveAll(Arrays.asList(a1,a2,b1,b2,b3));
        locationService.findAll().forEach(System.out::println);

        ProductFlag folia = new ProductFlag("folia");
        ProductFlag aluminium = new ProductFlag("aluminium");
        ProductFlag spozywcza = new ProductFlag("spożywcza");
        ProductFlag woreczek = new ProductFlag("woreczek");
        ProductFlag hdpe = new ProductFlag("HDPE");
        ProductFlag karton = new ProductFlag("karton");
        ProductFlag pizza = new ProductFlag("pizza");
        ProductFlag nadruk = new ProductFlag("nadruk");
        ProductFlag koperta = new ProductFlag("koperta");
        ProductFlag frytki = new ProductFlag("frytki");

        productFlagService.saveAll(Arrays.asList(folia,aluminium,spozywcza,woreczek,hdpe,karton,pizza,nadruk,koperta,frytki));
        productFlagService.findAll().forEach(System.out::println);


        Product kopertanaFrytki = Product.builder()
                .name("Koperta frytki foliowana duza 22cm a'200")
                .description("Koperta frytki foliowana duza 22cm a'200 Pojemnosc: 200g, pakowana jest po 200szt.")
                .barcode("592051235413")
                .locations(Arrays.asList(a1,b3))
                .pictureUrl("https://icons.iconarchive.com/icons/paomedia/small-n-flat/256/file-picture-icon.png")
                .productFlags(Arrays.asList(koperta,frytki,folia))
                .symbol("000000432541")
                .build();

        productService.save(kopertanaFrytki);


        Product kartonNaPizze = Product.builder()
                .name("Karton na pizze 22x22cm a'100 biale")
                .description("Kartony na pizze 22x22cm a'100 biale")
                .barcode("595000654644")
                .locations(Arrays.asList(a1,b2,b3))
                .pictureUrl("https://icons.iconarchive.com/icons/paomedia/small-n-flat/256/file-picture-icon.png")
                .productFlags(Arrays.asList(karton,pizza))
                .symbol("000000054234")
                .build();

        productService.save(kartonNaPizze);



        Product foliaAluminiowa = Product.builder()
                .name("Folia aluminiowa 0,28m 1kg FABRYKA POLSKA /Z4/")
                .description("Folia aluminiowa big rola. Szerokosc 28cm, waga 1kg +/-3%. Grubosc 13mic. Pakowana zbiorczo 6szt. w kartonie.")
                .barcode("59523624532")
                .locations(Arrays.asList(a2,b1,b3))
                .pictureUrl("https://icons.iconarchive.com/icons/paomedia/small-n-flat/256/file-picture-icon.png")
                .productFlags(Arrays.asList(aluminium,folia))
                .symbol("000000637353")
                .build();

        productService.save(foliaAluminiowa);


        productService.findAll().forEach(System.out::println);


    }

    public void createDeliveries(){
        Unit opakowanie = new Unit("opakowanie","op.");
        Unit rolka = new Unit("rolka","rol.");
        Unit sztuka = new Unit("sztuk","szt.");
        Unit karton = new Unit("karton/-ów","kart.");

        unitService.saveAll(Arrays.asList(opakowanie,rolka,sztuka,karton));
        unitService.findAll().forEach(System.out::println);

        Dealer ulex = new Dealer("Ulex","65235742");
        Dealer elpak = new Dealer("Elpak","56437854");
        Dealer hersta = new Dealer("Hersta","82896442");
        Dealer ika = new Dealer("Ika","102506724");
        Dealer radpak = new Dealer("Radpak","50231501");

        dealerService.saveAll(Arrays.asList(ulex,elpak,hersta,ika,radpak));
        dealerService.findAll().forEach(System.out::println);

        Supplier transportWlasny = new Supplier("Transport własny");
        Supplier pekaes = new Supplier("Pekaes");
        Supplier jasFbg = new Supplier("Jas Fbg");
        Supplier dhl = new Supplier("DHL");
        Supplier hellman = new Supplier("Hellman");
        Supplier schenker = new Supplier("Schenker");

        supplierService.saveAll(Arrays.asList(transportWlasny,pekaes,jasFbg,dhl,hellman,schenker));
        supplierService.findAll().forEach(System.out::println);

        Delivery dostawaZUlexu = Delivery.builder()
                .dealer(ulex)
                .creationTime(LocalDateTime.now())
                .info("Dostawa przyjechała z jedną uszkodzoną paletą jednak towar był kompletny")
                .picker(employeeSerivce.findById(1L).orElse(null))
                .supplier(pekaes)
                .build();

        ProductInDelivery kopertaNaFrytki = ProductInDelivery.builder()
                .product(productService.findById(1L).orElse(null))
                .quantity(4F)
                .unit(opakowanie)
                .delivery(dostawaZUlexu)
                .build();



        ProductInDelivery foliaAluminiowa = ProductInDelivery.builder()
                .product(productService.findById(3L).orElse(null))
                .quantity(6F)
                .unit(rolka)
                .delivery(dostawaZUlexu)
                .build();



        ProductInDelivery kartonNaPizze = ProductInDelivery.builder()
                .product(productService.findById(2L).orElse(null))
                .quantity(2F)
                .unit(opakowanie)
                .delivery(dostawaZUlexu)
                .build();


        dostawaZUlexu.setProductsInDelivery(Arrays.asList(kopertaNaFrytki,foliaAluminiowa,kartonNaPizze));


        Delivery savedDelivery = deliveryService.save(dostawaZUlexu);
        deliveryService.findAll().forEach(System.out::println);


        System.out.println();
        System.out.println();





    }


}
