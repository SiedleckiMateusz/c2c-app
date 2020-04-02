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
import java.util.Optional;

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
        Route lublinLH = new Route("LublinLH", new ArrayList<>());

        routeService.save(lublin);
        routeService.save(pulawy);
        routeService.save(krasnik);
        routeService.save(chelm);
        routeService.save(leczna);
        routeService.save(lublinLH);



        saveClient(Client.builder().warehouseName("LH KONWALIOWA").realName("Minuta 8").nip("9462640744").address("Konwaliowa 7, 20-258 Turka").coordinates(new Coordinates("51.274476","22.666250")).info("Stajemy przy drodze. Towar nosimy do tylnego wejscia").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH TURKA").realName("Top Market").nip("9462640744").address("Bukowa 2, 20-258 Turka").coordinates(new Coordinates("51.277517","22.658585")).info("Trzeba objechac budynek. Wejscie z tylu od ulicy klonowej").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH PODZAMCZE").realName("Top Market").nip("9462640744").address("ul. Podzamcze 254, 21-010 Leczna").coordinates(new Coordinates("51.335071","22.900224")).info("Brazowa brama po prawej stronie na koncu budynku").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("Biuromix, Leczna").realName("Sklep z art. papierniczymi Biuromix").nip("7132688698").address("Partyzancka 3, 21-010 Leczna").coordinates(new Coordinates("51.305546","22.881868")).info("Wejscie od frontu budynku").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("PERLOWA LECZNA").realName("Rest. Michele Fit&Cafe").nip("7131007437").address("Perlowa 3, 21-010 Leczna").coordinates(new Coordinates("51.295705","22.878802")).info("Towar nosimy na tyl budynku. mozna uzyc wozka do weozenia towaru i zaleca sie powolne przemieszczanie po atrapach desek").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("SANIT LUBARTOW").realName("Hurtownia hydrauliczna SANIT").nip("8212324906").address("Juliusza Slowackiego 52A, 21-100 Lubartow").coordinates(new Coordinates("51.471648","22.606967")).info("Glowne wejscie").route(new Route("Lubartów")).build());
        saveClient(Client.builder().warehouseName("KLOPS").realName("No to klops").nip("5050042635").address("Al. Jana Pawla II 191, 21-010 Leczna").coordinates(new Coordinates("51.299865","22.886624")).info("Towar znosimy po schodkach w dol z tylu budynku").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("STARY/ PUB 30").realName("Pub 30 s.c.").nip("5050042635").address("Stefanii Pawlak 40, 21-010 Leczna").coordinates(new Coordinates("51.299947","22.892533")).info("wejscie od ulicy Stefani Pawlak do piwnicy budynku. Wejscie wyglada jak zjazd do garazu podziemnego").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("GROSZEK LECZNA").realName("Sklep Groszek").nip("7133083402").address("kpt. Zabickiego 5, 21-010 Leczna").coordinates(new Coordinates("51.301217","22.896068")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("GROSZEK LANCUCHOW").realName("Sklep Groszek").nip("7133083402").address("Lancuchow 98A, 21-020 Lancuchow").coordinates(new Coordinates("51.260269","22.924955")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("CO TU JETA, MILEJOW").realName("CoTuJeta. Fast food & pizza").nip("5050050971").address("Partyzancka 11, 21-020 Milejow").coordinates(new Coordinates("51.224122","22.928321")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("GROSZEK MILEJOW").realName("Sklep Groszek").nip("7131007437").address("Partyzancka, 21-020 Milejow-Osada").coordinates(new Coordinates("51.223234","22.928632")).info("towar wnosimy do brazowych drzwi z prawej strony glownego wejscia").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("DELIKATESY CENTRUM, MILEJOW").realName("Sklep Delikatesy Centrum").nip("8212324906").address("Niepodleglosci 6, 21-020 Milejow-Osada").coordinates(new Coordinates("51.221077","22.927293")).info("towar wnosimy z tylu budynku na rampe").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("GROSZEK JASZCZOW").realName("Sklep Groszek").nip("7131007437").address("Jaszczow 207, 21-020 Jaszczow").coordinates(new Coordinates("51.212163","22.931290")).info("towar dostarczamy w ostatnie okienko po lewej stronie w budynku (okno piwnicy)").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("PIZZERIA JASZCZOW").realName("Vicenza. Pizzeria").nip("7131007437").address("21-020 Jaszczow 207, DW829, 21-020").coordinates(new Coordinates("51.212157","22.931428")).info("towar dostarczamy do okna po lewej stronie (okno na wysokosci parteru)").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("DELIKATESY CENTRUM, TRAWNIKI").realName("Sklep Delikatesy Centrum").nip("7131007437").address("Trawniki 620, 21-044 Trawniki").coordinates(new Coordinates("51.136511","22.995568")).info("towar zdajemy na rampie, dzwonimy dzwonkiem").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("KADO, PIOTRKOW").realName("Sklep Odido").nip("7131437965").address("Piotrkow Pierwszy 52A, 23-114 Piotrkow Pierwszy").coordinates(new Coordinates("51.045316","22.636945")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("MARS, JABLONNA").realName("Sklep Mars").nip("7131404977").address("Jablonna II 27").coordinates(new Coordinates("51.088627","22.585419")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("GROSZEK, JABLONNA").realName("Sklep Groszek").nip("8212324906").address("Jablonna 9, 23-114 Jablonna-Majatek").coordinates(new Coordinates("51.094597","22.580200")).info("towar dostarczamy na rampe od zaplecza").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("STOKROTKA, JABLONNA").realName("Sklep Stokrotka").nip("8212324906").address("Jablonna-Majatek 57B, 23-114 Jablonna-Majatek").coordinates(new Coordinates("51.100812","22.578311")).info("objezdzamy budynek po prawej stronie. Towar zdajemy w ostatnich drzwiach po tej stronie budynku").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("SKLEP METALOWY, OSMOLICE").realName("Wol-Bud Tonasz Wolski").nip("7121016699").address("Osmolice Pierwsze 22, 23-107 Osmolice Pierwsze").coordinates(new Coordinates("51.106023","22.500277")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("MAJ, CIUCH, BYCHAWA").realName("Odziez uzywana").nip("7122644280").address("Szkolna 2, 23-100 Bychawa").coordinates(new Coordinates("51.013346","22.533533")).info("Towar wnosimy glownym wejsciem ").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("BAR MILA").realName("Bar Mila").nip("7131611825").address("Zabia Wola 66B, 23-107 Zabia Wola").coordinates(new Coordinates("51.122975","22.515775")).info("glowne wejscie").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("Spoldzielnia Samopomoc").realName("Gminna Spoldzielnia Samopomoc chlopska").nip("7140200292").address("Przemyslowa 20, 21-100 Lubartow").coordinates(new Coordinates("51.438973","22.603772")).info("Glowne wejscie. Towar zostawiamy pod schodami. Po kase i podpis idziemy na I pietro").route(new Route("Lubartów")).build());
        saveClient(Client.builder().warehouseName("BEMA 6 FOTOGRAF").realName("Sklep Fotograficzny").nip("7131773663").address("gen. Jozefa Bema 6, 21-100 Lubartow").coordinates(new Coordinates("51.462859","22.607823")).info("Glowne wejscie").route(new Route("Lubartów")).build());
        saveClient(Client.builder().warehouseName("CIUCH LUBARTOW").realName("Dyskont odziezowy Tania Odziez").address("Armii Krajowej 12, 21-100 Lubartow").coordinates(new Coordinates("51.461955","22.609848")).info("Wejscie od tylu budynku po schodach w dol.").route(new Route("Lubartów")).build());
        saveClient(Client.builder().warehouseName("BIURPACK").realName("Biurpack Express").nip("8212463855").address("Juliusza Slowackiego 54, 21-100 Lubartow").coordinates(new Coordinates("51.471756","22.606896")).info("Towar ukladamy na paletach przed sklepem").route(new Route("Lubartów")).build());
        saveClient(Client.builder().warehouseName("Mal Mar").realName("Mal-Mar S.C. Przedsiebiorstwo Handlowo-Uslugowe").nip("7161004113").address("ul. Deblinska 6a, 24-100 Pulawy").coordinates(new Coordinates("51.429494","21.949798")).info("Mozna wjechac przez myjnie bezdotykowa. Nie poleca sie wjezdzac na rampe.").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("LH PULAWY").realName("TOP-MARKET").address("Hugona Kollataja 50, 24-100 Pulawy").coordinates(new Coordinates("51.421967","21.951479")).info("Wjezdzamy z prawej strony budynku pierwsze drzwi").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("DAR-PAK").realName("DAR-PAK Opakowania").nip("7160015729").address("Hugona Kollataja 18, 24-100 Pulawy").coordinates(new Coordinates("51.419206","21.953474")).info("Mala hurtownia, schodzi sie schodkami w dol. Malym samochodem mozna wiechac na plac od ulicy pustej. Duzym samochodem z duza iloscia towaru poleca sie wjechac od piaskowej miedzy stokrotka a Dywanami. Mozna tez zaparkowac na kallataja ale trzeba przejsc z towarem ze 20-25 metrow").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("MILA 23b").realName("Oranzeria").nip("7162561057").address("Centralna 23b, 24-100 Pulawy").coordinates(new Coordinates("51.417766","21.961329")).info("Wjezdzamy z tylu budynku i po prawej stronie mamy ostatnie drzwi przeszklone. Towar znosimy na dol na polpietro").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("MILA 1").realName("Cynamon").nip("7162561057").address("Centralna 1, 24-100 Pulawy").coordinates(new Coordinates("51.417058","21.967776")).info("Podjezdzamy tylem pod lokal. Z prawej strony tam gdzie wejscie do Peweksu wnosimy towar. Podobno mozna dostac mandat.... ale co tam. Dane c2c wystarczy podac :-D").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("KOMINEK").realName("Restauracja Kominek").nip("7162696389").address("Wojska Polskiego 8B, 24-100 Pulawy").coordinates(new Coordinates("51.417314","21.975474")).info("Glowne wejscie, na lewo schody w dol. Towar stawiamy przy lodowkach").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("ELGOS").realName("Elgos").nip("7160011105").address("Lubelska 16, 24-100 Pulawy").coordinates(new Coordinates("51.414884","21.979071")).info("Podjezdzamy pod glowne drzwi. Towar ustawiany na srodku sklepu. Prosze przygotowac duzo cierpliwosci do sprawdzania towaru.").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("CHEM-PAK").realName("P P H U Chem Pak").nip("7161777625").address("Pulawska 4, 24-170 Kurow").coordinates(new Coordinates("51.389456","22.184076")).info("Tel. do goscia po informacje czy towar dostarczamy do  domu czy na firme. Sa to dwa osobne miejsca ale niedaleko siebie").route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("27").realName("Gama - Sklep").nip("5632423737").address("Szpitalna 27, 22-100 Chelm").coordinates(new Coordinates("51.145357","23.455852")).info("Towar dostawrczamy tylnimi lub przednimi drzwiami. Dzwonimy dzwonkiem jesli tylem.").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("MG").realName("Magazyn gl. Spolem").nip("5632423737").address("Rejowiecka 181, 22-100 Chelm").coordinates(new Coordinates("51.145394","23.476778")).info("Wjezdzamy w droge wewnetrzna, po lewej stronie mamy Stacje Paliw. Trzymamy sie prawej strony. Mijamy glowny budynek i za budynkiem skrecamy w lewo. Stajemy po lewej stronie miedzy 2 a 3 drzwiami.").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("4").realName("Gama - Sklep").nip("5632423737").address("Targowa 1, 22-110 Ruda Huta").coordinates(new Coordinates("51.236090","23.593121")).info("Towar dostawrczamy z lewej strony budynku. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("22").realName("Gama - Sklep").nip("5632423737").address("Lubelska 54, 22-100 Chelm").coordinates(new Coordinates("51.134295","23.469782")).info("Towar dostarczamy tylnimi drzwiami. Najlepiej wjechac tylem na parking z tylu budynku. Wjazd na parking z prawej strony  budynku.").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("18").realName("Gama - Sklep").nip("5632423737").address("Lwowska 18, 22-100 Chelm").coordinates(new Coordinates("51.130483","23.470732")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("25").realName("Gama - Sklep").nip("5632423737").address("Sienkiewicza 7, 22-100 Chelm").coordinates(new Coordinates("51.135738","23.475520")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("85").realName("Gama - Sklep").nip("5632423737").address("Staroscinska 2, 22-100 Chelm").coordinates(new Coordinates("51.135589","23.483086")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("PH1").realName("Gama - Sklep").nip("5632423737").address("al. Pilsudskiego 26, 22-100 Chelm").coordinates(new Coordinates("51.138164","23.495130")).info("Podjezdzamy od tylu pod rampe, ukladamy towar na paletach i wprowadzamy palety do srodka. Dziewczyny sprawdzaja, a po podpis idziemy waskim korytarzem do biura po lewej stronie").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("35").realName("Gama - Sklep").nip("5632423737").address("Reja 32, 22-100 Chelm").coordinates(new Coordinates("51.132559","23.504706")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem. Wjazd z obydwu stron").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("21").realName("Gama - Sklep").nip("5632423737").address("Batorego 2, 22-100 Chelm").coordinates(new Coordinates("51.131360","23.490574")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("30").realName("Gama - Sklep").nip("5632423737").address("Hrubieszowska 67, 22-100 Chelm").coordinates(new Coordinates("51.127272","23.490353")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("2").realName("Gama - Sklep").nip("5632423737").address("Hrubieszowska 6, 22-113 Kamien").coordinates(new Coordinates("51.090993","23.576204")).info("Towar dostawrczamy z lewej strony budynku. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("28").realName("Gama - Sklep").nip("5632423737").address("Wolnosci 14a, 22-100 Chelm").coordinates(new Coordinates("51.121236","23.473504")).info("Towar dostarczamy glownym wejsciem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("36").realName("Gama - Sklep").nip("5632423737").address("Lwowska 85, 22-100 Chelm").coordinates(new Coordinates("51.122732","23.468529")).info("Wjezdzamy od prawej strony w droge obok budynku. Podjezdzamy od tylu i dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("26").realName("Gama - Sklep").nip("5632423737").address("Trubakowska 57, 22-100 Chelm").coordinates(new Coordinates("51.135837","23.447144")).info("Towar dostawrczamy tylnimi drzwiami. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("3").realName("Gama - Sklep").nip("5632423737").address("Krolowej Sonki 1, 22-113 Krasnystaw").coordinates(new Coordinates("50.991535","23.150691")).info("Towar dostarczamy bocznym wejsciem z prawej strony od frontu budynku. Dzwonimy dzwonkiem").route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("DAM").realName("Sklep Wielobranzowy").nip("7131585424").address("Krotka 1a, 24-220 Niedrzwica Duza").coordinates(new Coordinates("51.111114","22.385320")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("TB KAM").realName("Sklep Kropka").nip("7151049479").address("23-212 Wilkolaz Pierwszy 14").coordinates(new Coordinates("51.003089","22.338907")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("BANACH").realName("Sklep Lewiatan").nip("7121417197").address("Wilkolaz Pierwszy 16, 23-212 Wilkolaz Pierwszy").coordinates(new Coordinates("51.003973","22.338754")).info("Towar dostawrczamy od parkingu. Sol tabletkowa zostawiana jest na zewnatrz").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("JAR KRAS").realName("Przysmaki Pani Ewy").nip("7151018450").address("Tadeusza Kosciuszki 7A, 23-200 Krasnik").coordinates(new Coordinates("50.921016","22.218541")).info("wjezdzamy od ulicy wierzbowej i po prawo jest brama").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("GROSZEK KOSZAROWA").realName("Sklep groszek").address("Koszarowa 12, 23-200 Krasnik").coordinates(new Coordinates("50.928592","22.228016")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("MAJ KRASNIK").realName("Ciuchland").nip("7122644280").address("Chopina, 23-200 Krasnik").coordinates(new Coordinates("50.931094","22.225515")).info("Wjazd przez parking biedronki, na koncu jest brama. Jesli jest zamknieta to od ul. Mieszka I").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("T-GAZ").realName("Sklep Z art.. Metalowymi T-GAZ").nip("7151703795").address("Aleja Mlodosci 1, 23-204 Krasnik").coordinates(new Coordinates("50.957429","22.184778")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("SHARMA OPOLE KRZYWE KOLO").realName("Kebab Sharma").nip("6581907962").address("Krzywe Kolo 85, 24-300 Opole Lubelskie").coordinates(new Coordinates("51.147860","21.955141")).info("glowne wejscie").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("GROSZEK SPORTOWA").realName("Sklep Groszek").address("Sportowa 2, 23-204 Krasnik").coordinates(new Coordinates("50.963535","22.157720")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("WOJCIK").realName("Sklep spozywczy Nasz sklep").nip("7150001453").address("Klodnica Dolna 53").coordinates(new Coordinates("51.065685","22.292230")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("PIZZERIA NA GORCE").realName("Pizzeria Na gorce").address("Borzechow 5").coordinates(new Coordinates("51.089172","22.281853")).info("Towar wnosimy do budynku obok. Trzeba pojsc po kogos aby otworzyl drzwi").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("ABC SKLEP borzechow").realName("Sklep ABC").nip("7150001453").address("Borzechow-Kolonia 105, 24-224 Borzechow-Kolonia").coordinates(new Coordinates("51.090199","22.304646")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("EVA PARTYZANTOW").realName("Sklep Nasz Sklep").nip("7171108920").address("Partyzantow 40, 24-350 Chodel").coordinates(new Coordinates("51.113849","22.138545")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("EVA RATOSZYNSKA").realName("Sklep Groszek").nip("7171108920").address("Mostowa 7, 24-350 Chodel").coordinates(new Coordinates("51.107950","22.129648")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("GODOW 104A").realName("Sklep spozywczy").nip("7170000669").address("Godow 104 A").coordinates(new Coordinates("51.091804","22.111656")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("TOMAR").realName("Tomar plus").nip("7411595895").address("Jozefa Pilsudskiego 17, 24-300 Opole Lubelskie").coordinates(new Coordinates("51.147962","21.971046")).info("Trzeba zapytac gdzie wnosic towar. Nie ma gdzie zaparkowac. ").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("MAJ OPOLE").realName("Ciuchland").nip("7122644280").address("Lubelska 12, 24-300 Opole Lubelskie").coordinates(new Coordinates("51.149510","21.970761")).info("Budynek Poczty. Wejscie od prawej strony za brama.").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("ZABKA OPOLE").realName("Sklep Zabka").nip("7161483929").address("Nowy Rynek 4, 24-300 Opole Lubelskie").coordinates(new Coordinates("51.147352","21.969535")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("MAJ BELZYCE").realName("Ciuchland Centrum Chinskie").nip("7122644280").address("Spoldzielcza 2, 24-200 Belzyce").coordinates(new Coordinates("51.175374","22.281526")).info("Wchodzimy przez sklep Stokrotka i idziemy na pierwsze pietro").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("THAI STORY").realName("Restauracja Thai Story").nip("7123303612").address("Peowiakow 2, 20-007 Lublin").coordinates(new Coordinates("51.246234","22.560491")).info("Wjezdzamy w brame, jesli potrzebny klucz to idziemy do goscia po prawo co sprzedaje buty. Nie stawac na chodniku bo czesto straz miejska jezdzi.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("UMEA").realName("Restauracja Umea, kuchnia weganska").nip("5631873124").address("Orla 4/1, 20-022 Lublin").coordinates(new Coordinates("51.244950","22.555922")).info("Towar wnosimy w brame na prawo po schodkach, drzwi na wprost - naprzeciwko wejscia do restauracji Umea. Parkujemy na chodniku przed lokalem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("30+").realName("Klub 30+").nip("7123097874").address("Jasna 7, 20-077 Lublin").coordinates(new Coordinates("51.249093","22.552993")).info("Wjezdzamy na parking platny przed lokalem i mowimy parkingowemu z dostawa. Jesli drzwi sa zamkniete to zadzwonic mozna do p. Anety (+48 506 338 640) lub do Przemka N.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("GROSZEK JACZEWSKIEGO").realName("Sklep Groszek").nip("7131512477").address("Jaczewskiego 8, 20-090 Lublin").coordinates(new Coordinates("51.258070","22.563795")).info("Wjezdzamy w brame ze szlabanem i mamy 10 min aby wyjechac i nie placic za parking. Za szlabanem skrecamy w lewo i po prawej stronie szukamy okraglego budynku. Wchodzimy i skrecamy w prawo. Po prawej drzwi do sklepu a na wprost drzwi gdzie zostawiamy towar.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("HAI AHN TUYEN VAN").realName("Restauracja Hai Anh").nip("7123374440").address("Wladyslawa Kunickiego 220, 20-458 Lublin").coordinates(new Coordinates("51.211443","22.584700")).info("Parkujemy przy budynku i towar wnosimy glownym wejsciem i stawiamy po prawej od lady").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TRYBUNALSKA").realName("Trybunalska City Pub").address("Rynek 4, 20-400 Lublin").coordinates(new Coordinates("51.248021","22.567554")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CIUCH JANA PAWLA").realName("Mega Dyskont Odziezowy").nip("9462205534").address("Jana Pawla II 13/1, 20-400 Lublin").coordinates(new Coordinates("51.228082","22.518813")).info("Towar dostarczamy z tylu budynku.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZIC").realName("Z I C - Hurtownia opakowan. PPHU Z i C").nip("7123301493").address("Skromna 20, 20-718 Lublin").coordinates(new Coordinates("51.247748","22.511174")).info("towar zdajemy na rampie przy budynku. Jak dziala dzwonek to dzwonimy dzwonkiem a jak nie to walimy w drzwi windy").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KA2").realName("Kantyna N14").nip("9462675530").address("Naleczowska 14, 20-701 Lublin").coordinates(new Coordinates("51.248568","22.518277")).info("Glowne wejscie calego budynku, na  holu ostatnie drzwi po prawej, za drzwiami nastepne drzwi na wprost").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("AGNES").realName("Agnes Beauty&Cosmetics").nip("7122440293").address("Zana 19, 20-601 Lublin").coordinates(new Coordinates("51.240784","22.520345")).info("sklep w budynku leclerc na poziomie -1, miedzy kwiaciarnia a dorabianiem kluczy").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LE MONDE").realName("Le Monde").address("Tomasza Zana 19, 20-400 Lublin").coordinates(new Coordinates("51.241160","22.519087")).info("Leclerc Zana, glowne wejscie od ronda. Towar wnosimy tylnimi bialymi drzwiami z lewej strony").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TUTTI GUSTI").realName("Tutti Gusti").nip("9461111593").address("Pana Balcera 6b, 20-631 Lublin").coordinates(new Coordinates("51.237016","22.528544")).info("glowne wejscie do restauracji").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SMAQ").realName("Garmazerka SMAQ - SMACZNA KUCHNIA").address("Wigilijna 2b, 20-001 Lublin").coordinates(new Coordinates("51.232634","22.539607")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MOZZA").realName("MOZZA").nip("7122990734").address("aleja Warszawska 95, 20-824 Lublin").coordinates(new Coordinates("51.262615","22.506401")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA SWIDNIK").realName("Sklep Zabka").nip("7131151677").address("gen. L.Okulickiego 20B/3, 21-040 Swidnik").coordinates(new Coordinates("51.220785","22.708417")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ATRIUM").realName("Bar Atrium").nip("7122673152").address("Rynek 2, 20-110 Lublin").coordinates(new Coordinates("51.247923","22.567427")).info("Towar dostarczamy glownym wejsciem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ACERNA").realName("Pizza Pub ACERNAs").address("Rynek 2, 20-111 Lublin").coordinates(new Coordinates("51.248016","22.567215")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ARTE").realName("Restauracja Arte del Gusto").address("Zeslancow Sybiru 5, 20-008 Lublin").coordinates(new Coordinates("51.245465","22.556928")).info("Towar wnosimy bocznym wejsciem od tylu restauracji (wejscie do Helium). Po wejsciu od razu na lewo do kuchni").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KUCHNIA SMAKOW").realName("Kuchnia Smakow- Garmazerka").nip("7123338728").address("Gorska 7, 20-863 Lublin").coordinates(new Coordinates("51.267348","22.555447")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KOBI").realName("Kobi Sushi").nip("815349374").address("Tadeusza Kosciuszki 10, 20-006 Lublin").coordinates(new Coordinates("51.246719","22.559896")).info("Towar dostarczasz ok 10 metrow przed Kobi. Magazynek schodkami w dol. Magazynek otwiera osoba z lokalu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PELIER").realName("Pelier Bistro").address("Deptak, Krakowskie Przedmiescie 10, 20-400 Lublin").coordinates(new Coordinates("51.247488","22.564688")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CHATA").realName("Chata Swojsko Strawa").address("Nadbystrzycka 16, 20-618 Lublin").coordinates(new Coordinates("51.238039","22.551105")).info("Towar dostarczamy do pierwszych drzwi po lewej, schodkami w dol").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("AL. NERO").realName("Pizza Al Nero").address("Weteranow 19, 20-044 Lublin").coordinates(new Coordinates("51.248655","22.533212")).info("Towar wnosimy glownym wejsciem.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ARCHE").realName("Arche Hotel Lublin").address("Zamojska 30, 20-105 Lublin").coordinates(new Coordinates("51.239985","22.570892")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RADOSC/ MILOSC").realName("Radosc").address("Bernardynska 15, Lublin").coordinates(new Coordinates("51.243424","22.566072")).info("Towar dostarczamy po godz. 15").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TANIA ODZIEZ GLEBOKA").address("Gleboka 8A, 20-612 Lublin").coordinates(new Coordinates("51.239608","22.549962")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TANI ARMANI").address("Lwowska 12F, 20-128 Lublin").coordinates(new Coordinates("51.255943","22.579824")).info("glowne wejscie po schodach na gore. Stajemy od ul. Jacka Kuronia i przechodzimy przez tunel i skrecamy w prawo").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LH KREZNICKA").realName("Sklep Top Market").address("Kreznicka 222C, 20-518 Lublin").coordinates(new Coordinates("51.165452","22.494359")).info("Rampa z lewej strony sklepu").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH NOWY SWIAT").realName("Sklep Top Market").address("Nowy Swiat 37F, 20-418 Lublin").coordinates(new Coordinates("51.224771","22.561093")).info("Towar dostarczamy z tylu budynku").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH GLUSK").realName("Sklep Top Market").address("Gluska 133, 20-380 Lublin").coordinates(new Coordinates("51.195613","22.594956")).info("Wjezdzajac na parking drzwi na wprost").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("ROMERA 71").realName("Sklep wedkarski Szczupaczek").address("E. Romera 71, 20-487 Lublin").coordinates(new Coordinates("51.208082","22.541327")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SANTERM").realName("Santerm Sp. z o.o. Grupa SBS").address("Energetykow 19, 20-468 Lublin").coordinates(new Coordinates("51.208925","22.555770")).info("glowne wejscie po schodach na pierwsze pietro").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA TARASOWA").realName("Sklep Zabka").nip("7122341740").address("Tarasowa 3, 20-819 Lublin").coordinates(new Coordinates("51.265788","22.520348")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KUCHNIA ALTANOWA").realName("Kuchnia Staropolska").address("Altanowa 4, 20-819 Lublin").coordinates(new Coordinates("51.265479","22.521866")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BAR POSPIECH").realName("Pospiech. Bar. Trzcinska G.M.").address("Lubartowska 26, 20-085 Lublin").coordinates(new Coordinates("51.252727","22.568560")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CARMELITO").realName("CARMELITO Lody").nip("9461323384").address("Krakowskie Przedmiescie 2, 20-002 Lublin").coordinates(new Coordinates("51.247422","22.565613")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("STUDNIA").realName("Studnia Pub i Restauracja").address("Krakowskie Przedmiescie 22, 20-001 Lublin").coordinates(new Coordinates("51.247507","22.563755")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BOMBARDINO NARUTOWICZA/ PANI Z WYPIEKAMI").realName("Bombardino Aperitivo").nip("7122681476").address("Narutowicza 19, 20-004 Lublin").coordinates(new Coordinates("51.246263","22.560679")).info("Wjezdzamy w brame, jesli potrzebny klucz to idziemy do goscia po prawo co sprzedaje buty. Nie stawac na chodniku bo czesto straz miejska jezdzi. Towar w nosimy od Thai Story na lewo, drzwi w rogu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LUBELNIA").realName("Galeria Lubelnia").address("Lipowa 3, 20-400 Lublin").coordinates(new Coordinates("51.246803","22.551677")).info("Glowne wejscie po schodach w dol").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA SZMARAGDOWA").realName("Sklep Zabka").nip("7122341740").address("Szmaragdowa 24, 20-570 Lublin").coordinates(new Coordinates("51.226742","22.518923")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("JAGIENKA").realName("Jagienka. Bar").address("Juranda 7, 20-629 Lublin").coordinates(new Coordinates("51.238513","22.520775")).info("Towar dostarczamy tylnimi drzwiami od parkingu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TAKUSHI").realName("Takushi Sushi").address("Pana Balcera 6A, 20-631 Lublin").coordinates(new Coordinates("51.236431","22.528064")).info("Towar dostarczamy z lewej strony budynku. Tam jest winda ale kluczyk do windy dostaniemy na gorze w Takushi").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MIASTO KOBIET").realName("Miasto Kobiet Fitness and More").address("Kazimierza Wielkiego 8, 20-001 Lublin").coordinates(new Coordinates("51.237989","22.531678")).info("Wiezdzamy glownym wjazdem na parking. Parkingowemu mowimy ze z dostawa. Podjezdzamy jak najblizej zjazdu w dol. Towar znosimy poniewaz nie da sie blizej podjechac.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("GRUBY BENEK").realName("Gruby Benek").address("Droga Meczennikow Majdanka 9, 20-300 Lublin").coordinates(new Coordinates("51.233987","22.583489")).info("Stajemy na chodniku przed wejsciem. Towar wnosimy glownymi drzwiami").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LH OKRZEI").realName("Sklep Top Market").address("Stefana Okrzei 2, 20-128 Lublin").coordinates(new Coordinates("51.256445","22.584020")).info("Wjwzdzamy do konca za garmazerka. Miedzy garmazerka a fryzjerem sa biale drzwi. Dzwonimy dzwonkiem przy tych drzwiach i idziemy do samego konca. Tam nam otworza").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH TUMIDAJSKIEGO").realName("Sklep Top Market").address("Kazimierza Tumidajskiego 18A, 20-400 Lublin").coordinates(new Coordinates("51.258245","22.590646")).info("Wjazd od ul. Niepodleglosci 5. Wjazd w do konca tunelu na zaplecze w prawo").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH POGODNA").realName("Sklep Top Market").address("Pogodna 42, 20-337 Lublin").coordinates(new Coordinates("51.233558","22.596546")).info("Wjazd na zaplecze od parkingu przy sklepie (tunel)").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH BUKOWA").realName("Sklep Top Market").address("Bukowa 15, 20-374 Lublin").coordinates(new Coordinates("51.228832","22.582538")).info("Towar zdajemy na rampie").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("KONIEC").realName("Pub KONIEC").address("Nadbystrzycka 20B, 20-618 Lublin").coordinates(new Coordinates("51.237678","22.551418")).info("Towar wnosimy glownym wejsciem. Towar stawaimy przy barze").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KARDAMON").realName("Kardamon").address("Krakowskie Przedmiescie 41, 20-002 Lublin").coordinates(new Coordinates("51.247943","22.556971")).info("Wjezdzamy w brame i po prawej wejscie do piwnicy").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BAR A BOO").realName("Bar a Boo").address("Prezydenta Gabriela Narutowicza 9, 20-400 Lublin").coordinates(new Coordinates("51.247156","22.563566")).info("Towar wnosimy glownym wejsciem po schodkach. Towar stawaimy przy barze").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("OSTRO").realName("Ostro Klubokawiarnia").address("Krakowskie Przedmiescie 25, 20-002 Lublin").coordinates(new Coordinates("51.248062","22.562327")).info("Wjazd od zielonej. Stajemy na miejscu dla zaopatrzenia i idziemy do baru aby powiadomili kucharza. On schodzi i otwiera drzwi z boku budynku").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA GODEBSKIEGO").realName("Sklep Zabka").address("Cypriana Godebskiego 3-5, 20-045 Lublin").coordinates(new Coordinates("51.248020","22.535515")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LH KIEPURY").realName("Sklep Top Market").address("Kiepury 11A, 20-838 Lublin").coordinates(new Coordinates("51.257447","22.542945")).info("Wjezdzamy w tunel przy budynku drzwi po prawej w glebi").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("PIZZA ZAMKOWA").realName("Pizzeria Zamkowa").address("plac Zamkowy 2, 20-121 Lublin").coordinates(new Coordinates("51.250394","22.569590")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("VIVA GALA").realName("VIVE Profit").address("Galeria Gala Dom i Wnetrze, Fabryczna 2, 20-301 Lublin").coordinates(new Coordinates("51.238710","22.572421")).info("Gala rampa od tylu budynku, winda na 1 poziom i glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BADUCHOWSKI").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("AS PRO").realName("AS-PRO Centrum ogrodnicze, Sklad budowlany").nip("7151119777").address("Karminowa 3, 21-002 Jastkow").coordinates(new Coordinates("51.292106","22.498962")).info("glowne wejscie").build());
        saveClient(Client.builder().warehouseName("BON APETIT").realName("Apetito").address("Tomasza Zana 32b, 20-601 Lublin").coordinates(new Coordinates("51.239803","22.525851")).info("wjazd od ul. wallenroda przez szlaban, drzwi na wprost za szlabanem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CLEOPATRA TESCO").realName("Cleopatra. Restauracja").address("Orkana 4, 20-400 Lublin").coordinates(new Coordinates("51.235700","22.493833")).info("Glowne wejscie Tesco i na wprost").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SOLIDEZ").realName("Solidez").address("Wojciechowska 5A, 20-704 Lublin").coordinates(new Coordinates("51.247327","22.511531")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("DARPIEK").realName("Piekarnia w Stokrotce").nip("7130014369").address("Abramowice Prywatne 56, 20-388 Abramowice Prywatne").coordinates(new Coordinates("51.205728","22.631355")).info("Wchodzimy do wysokiego budynku po schodkach, drzwiami po prawej stronie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ONIFER").realName("Il Rifugio. Pizzeria").nip("7120154181").address("Wojciecha Oczki 3, 20-435 Lublin").coordinates(new Coordinates("51.214507","22.583089")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MASTERMEDIA").realName("Mastermedia").nip("7120155884").address("Tokarska 6, 20-210 Lublin").coordinates(new Coordinates("51.240549","22.617359")).info("Podjezdzamy w miare mozliwosci pod rampe. Idziemy z dokunentami do biura miedzy rampa dla tirow (nr 4) a rampa reczna w srodku budynku.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PAPRIKA 68").realName("Paprika Kebab").address("Krakowskie Przedmiescie 68, 20-006 Lublin").coordinates(new Coordinates("51.247687","22.554849")).info("wjazd od ul. Chopina przy starym kiosku parking na rogu z ul. krakowiskie przedmiescie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PAPRIKA 8").realName("KEBAB PAPRIKA").address("Krakowskie Przedmiescie 8, 20-002 Lublin").coordinates(new Coordinates("51.247460","22.564960")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MALE INDIE").realName("Male Indie Restauracja Wegetarianska").address("Rybna 2, 20-114 Lublin").coordinates(new Coordinates("51.248334","22.567438")).info("Wjezdzamy na rynek przed trybunalska . Wchodzimy w brame, na koncu po prawej drzwi informujemy o dostawie. Gosc otwiera nam garaz po lewej i tam zostawiamy towar. Dobrze jest speak English.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("JURANDA").realName("Centrum medyczne JURANDA").nip("7122679485").address("Juranda 9, 20-629 Lublin").coordinates(new Coordinates("51.239042","22.521188")).info("Wjechac od strony parkingu po chodniku pod same drzwi, towar znosimy na poziom -1").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MERKURIUSZ").realName("Groszek Sklep z art. spozywczymi").address("Niccolo Paganiniego 9, 20-850 Lublin").coordinates(new Coordinates("51.255392","22.551752")).info("Brazowe drzwi po prawej stronie sklepu (rampa) z lewej strony w rogu dzwonek. Czesto nie otwieraja i trzeba pojsc na sklep i powiedziec ze sie jest").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BOMBARDINO GESIA").realName("Bombardino Trattoria").nip("7122570914").address("Gesia 5, 20-719 Lublin").coordinates(new Coordinates("51.227964","22.480728")).info("Wjezdzamy od strony parkingu i towar wnosimy przez hol miedzy restauracja i pozostala czescia budynku. Schodzimy schodami w dol naprzeciwko ochrony i tam zostawiamy towar. Wolamy kogos z rest. do sprawdzenia").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("JONAR").realName("Jonar. Produkcja odziezy roboczej i dystrybucja art. bhp").nip("9181782300").address("Malwowa 28, 21-040 Kalinowka").coordinates(new Coordinates("51.205944","22.635444")).info("Info ze jestesmy w biurze. Towar zdajemy na magazyn na koncu posesji").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("FRIZANTE").realName("Frizzante").address("Relaksowa 24, 20-819 Lublin").coordinates(new Coordinates("51.267396","22.526970")).info("Towar dostarczamy po prawej stronie od wejscia w tunelu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("NOZ").realName("NOZ - kuchnia i bar").address("Tadeusza Kosciuszki 3, 20-006 Lublin").coordinates(new Coordinates("51.247064","22.559910")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("EKO-DAM").realName("Eko-Dam. PHU. Hurtownia chemiczna").nip("9181581955").address("Pawia 49, 20-343 Lublin").coordinates(new Coordinates("51.226894","22.575219")).info("Podjezdzamy pod boczna brame- NIE pod glowna. Jesli zamkniete to dzwonic dzwonkiem.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PRZYCHODNIA PRZYJAZNI").realName("Przychodnia Lublin - Centrum Medyczne Przyjazni Sp. z o.o.").address("Przyjazni 13, 20-314 Lublin").coordinates(new Coordinates("51.243889","22.588818")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("JAGODKA").realName("Garmazerka Jagodka").address("Stokrotka, Kreznicka 1a, 20-525 Lublin").coordinates(new Coordinates("51.194208","22.527073")).info("Garmazerka w budynku Stokrotki").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("POSTER WROBLEWSKIEGO").realName("Kiosk").nip("7120253026").address("Walerego Wroblewskiego, Lublin").coordinates(new Coordinates("51.247355","22.563673")).info("glowne wjescie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KARTEL").realName("Kartel Mexican Food").nip("7123124602").address("Lubartowska 53, 20-400 Lublin").coordinates(new Coordinates("51.253765","22.569354")).info("Food truck przy rondzie na Zana. Wjazd na parking przy banku i tam jak zjedziemy parkingiem w dol to przy rondzie jest ta przyczepa").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CIUCH DIAMENTOWA").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MONTOWNIA MOCY").realName("Auto mechanika Montownia Mocy").address("Dluga 79, 20-365 Lublin").coordinates(new Coordinates("51.227401","22.582495")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA ROMERA").realName("Sklep Zabka").nip("9462598700").address("Eugeniusza Romera 26, 20-470 Lublin").coordinates(new Coordinates("51.210403","22.542150")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PESTO").address("Legionowa 5, 20-053 Lublin").coordinates(new Coordinates("51.251377","22.532227")).info("Towar znosimy po schodkach glownym wejsciem. Po wejsciu do lokalu towar zostawiamy od razu na lewo przy schowku").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZLOTY KURCZAK LEONARDA").nip("7120306395").address("Leonarda 3, 20-400 Lublin").coordinates(new Coordinates("51.240956","22.517780")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SPA ORKANA").realName("Spa Orkana").address("Szaserow 2, 20-553 Lublin").coordinates(new Coordinates("51.233200","22.504664")).info("Towar wnosimy glownym wejsciem pietro nizej i ustawiamy pod sciana naprzeciwko windy. Nastepnie dzwoniimy do obslugi i ktos sprawdzi i odbierze towar").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SZKOLA BIEDRONKI").realName("Zespol szkol nr 10").address("Biedronki 13, 20-543 Lublin").coordinates(new Coordinates("51.229948","22.506949")).info("wjazd przez brame towar zdajemy w brazowych drzwiach po lewej na placu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA BASNIOWA").realName("Sklep Zabka").nip("7121852705").address("Basniowa 8, 20-802 Lublin").coordinates(new Coordinates("51.251719","22.517962")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ANABILIS").realName("Anabilis").address("Lubartowska 7, 20-400 Lublin").coordinates(new Coordinates("51.248008","22.566079")).info("od rynku wjazd jadac od bramy krakowskiej pierwsze przeszklone drzwi po lewej").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("COFFEE TIME").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LUXOR WARSZAWSKA").address("aleja Warszawska 175a, 20-824 Lublin").coordinates(new Coordinates("51.274785","22.486507")).info("dajemy znac na recepcji. Wjazd na koncu posesji na poziom -1").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("OHAE OLIMP").realName("Sklep Ohae").address("Aleja Spoldzielczosci Pracy 34, 20-147 Lublin").coordinates(new Coordinates("51.266509","22.571764")).info("Najnowsza czesc budynku poziom 1").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TRAKT KROLEWSKI").realName("Restauracja Trakt Krolewski").address("Grodzka 7, 20-400 Lublin").coordinates(new Coordinates("51.248686","22.568618")).info("telefon przed dostawa glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("APTEKA NARUTOWICZA 83").realName("Apteka").nip("7121451811").address("Prezydenta Gabriela Narutowicza 83, 20-019 Lublin").coordinates(new Coordinates("51.239687","22.552770")).info("Wjazd na rogu przy czerwonym kiosku. Towar wnosimy od tylu brazowe drzwi w bloku za bramka").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CHRIST").realName("Restauracja Christ").nip("7121686218").address("Kazimierza Wielkiego 8, 20-611 Lublin").coordinates(new Coordinates("51.238309","22.532562")).info("Towar wnosimy od parkingu przy hali globus").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SHARMA OPOLE POPIJARSKA").realName("Kebab Sharma").nip("6581907962").address("Popijarska 10/8, 24-300 Opole Lubelskie").coordinates(new Coordinates("51.146435","21.970109")).info("Towar dostarczamy glownym wejsciem").route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("CASPER KRASNIK").realName("Magazyn Casper").nip("871674494").address("Lipowa 65, 23-206 Stroza-Kolonia").coordinates(new Coordinates("50.902849","22.292668")).route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("SPIZARNIA SMAKU").realName("Spizarnia Smaku").nip("7123385892").address("Dominikanska 5, 20-400 Lublin").coordinates(new Coordinates("51.274404","22.569376")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("C2C").realName("Nazwa rzeczywista").nip("9462637937").address("Zawieprzycka 8i, 20-228 Lublin").coordinates(new Coordinates("51.260288","22.630883")).info("Najlepiej tam nie jezdzic ;)").build());
        saveClient(Client.builder().warehouseName("ARTSYL").realName("Artsyl Artur Kaczor").nip("7961480944").address("Wiejska 113, 26-600 Radom").coordinates(new Coordinates("51.369948","21.150413")).info("Towar dostarczamy na podwÄ‚Ĺ‚rko prywatne. Mozna zadzwonic do osoby ktora zajmuje siĂ„Â™ rozladunkiem. Nr 48 509 926 061").route(new Route("Radom")).build());
        saveClient(Client.builder().warehouseName("BIURPACK LECZNA").realName("Dostawa towaru do Sanit'u w Lecznej").nip("8212463855").address("Pilsudskiego 41, 21-010 Leczna").coordinates(new Coordinates("51.301446","22.886913")).info("Dostawa od zaplecza z tylu budynku").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("ALERT").realName("Alert. Hurtownia opakowan i Chemii Gospodarczej Trela").nip("9462534048").address("Firlejowska 32j, 20-306 Lublin").coordinates(new Coordinates("51.243156","22.582631")).info("Wjezdzamy na plac i pytamy chlopakow gdzie rozladunek").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("FOCUS PODZAMCZE").realName("Hotel Focus").nip("9671347422").address("Podzamcze 1, 20-126 Lublin").coordinates(new Coordinates("51.254161","22.575980")).info("Towar dostarczamy na prawo od glownego wejscia, na rogu budynku schodami w dol drugie drzwi. Tam dzwonimy dzwonkiem jest jest zamkniete").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LUBELSKA REGIONALNA").realName("Budynek Informacji turystycznej").nip("7122985207").address("Jezuicka 1/3, 20-029 Lublin").coordinates(new Coordinates("51.247622","22.566698")).info("Towar wnosimy do informacji turystycznej i idziemy do recepcji na wprost, NIE na prawo, tam pytamy gdzie zostawic towar").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BAR KROKIECIK").realName("Krokiecik. Bar").nip("7120069966").address("Lubartowska 17, 20-084 Lublin").coordinates(new Coordinates("51.248932","22.566348")).info("Towar wnosimy glownym wejsciem i zostawiamy przy ladzie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LH RAABEGO").realName("Sklep Minuta 8").address("Rektora Henryka Raabego 2, 20-030 Lublin").coordinates(new Coordinates("51.244619","22.544676")).info("Glowne wejscie").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("LH 1-GO MAJA").realName("Sklep Top Market").address("1 Maja 34, 20-410 Lublin").coordinates(new Coordinates("51.233017","22.569398")).info("na przeciwko glownego wejscia. przy samochodach stajemy. brama metalowa po prawej stronie i tam").route(new Route("LublinLH")).build());
        saveClient(Client.builder().warehouseName("POSTER SAMSONOWICZA").realName("Kiosk").nip("7120253026").address("Jana Samsonowicza 3, Lublin").coordinates(new Coordinates("51.213200","22.546430")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("POSTER RACLAWICKIE").realName("Kiosk").nip("7120253026").address("Aleje Raclawickie 44, Lublin").coordinates(new Coordinates("51.251106","22.527185")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZLOTY KURCZAK ZAGLEBOCZE").realName("Rest. Zloty Kurczak").nip("7120306395").address("Lejno Jezioro Zaglebocze, 21-230 Sosnowica").coordinates(new Coordinates("51.433692","23.029326")).info("Towar dostarczamy od tylu budynku, trzecie zaplecze od lewej").route(new Route("Łęczna")).build());
        saveClient(Client.builder().warehouseName("MPAK SWIDNIK").nip("7131315966").address("Jarzebinowa 49A, 21-007 Krepiec").coordinates(new Coordinates("51.197511","22.725920")).info("numer telefonu do klienta 516 670 270, prywatny dom").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("WIDOK").realName("Widok, lody, sushi, pizza, plac zabaw, plaza").nip("7121079688").address("Kreznicka 14, 20-518 Lublin").coordinates(new Coordinates("51.185604","22.524670")).info("Towar ustawiamy w przesciu pomiedzy budynkami").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("STELLA LUBARTOW").realName("Stella Magazyn").nip("7141712077").address("Lubartow").info("Portiernia informuje gdzie rozladowac towar").route(new Route("Parczew")).build());
        saveClient(Client.builder().warehouseName("BARTOSZ").realName("Hurtownia Bartosz S.C.").nip("5391495711").address("Nowa 39, 21-200 Parczew").coordinates(new Coordinates("51.641597","22.902099")).info("Glowne wejscie").route(new Route("Parczew")).build());
        saveClient(Client.builder().warehouseName("SZKOLNA 15").realName("Sklep").nip("539302178").address("Szkolna 5, 21-200 Parczew").coordinates(new Coordinates("51.642365","22.913092")).info("Glowne wejscie").route(new Route("Parczew")).build());
        saveClient(Client.builder().warehouseName("FASHION ANNA MAJ").realName("Ciuch").nip("7122644280").address("Szeroka 2, 21-200 Parczew").coordinates(new Coordinates("51.641982","22.899507")).info("Glowne wejscie").route(new Route("Parczew")).build());
        saveClient(Client.builder().warehouseName("SZWEJK OLIMP").realName("Szwejk").nip("7123106745").address("Aleja Spoldzielczosci Pracy 34, 20-001 Lublin").coordinates(new Coordinates("51.265187","22.570072")).info("Podjezdzamy od tylu na parking dostaw. Jedziemy z towarem na pierwsze pietro. Idziemy korytarzem prosto az wyjdziemy na galerie. Mijamy korytarz i jeden sklep po prawo a za sklepem jest korytarz dla dostaw. Sa to 2 lub 3 drzwi na lewo").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("GOFRY WILENSKA").realName("Gofry u Ireny").nip("7122302378").address("Wilenska 21, 20-603 Lublin").coordinates(new Coordinates("51.242506","22.519102")).info("Towar dostarczamy z tylu. Szyld gofry i zakratowane drzwi, mala rampa.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("GOFRY OLIMP").realName("Gofry u Ireny").nip("7122302378").address("Aleja Spoldzielczosci Pracy, 20-400 Lublin").coordinates(new Coordinates("51.266532","22.571530")).info("wchodzimy drzwiami po lewej od stokrotki. schodami ruchomymi na gore i na prawo").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("STYK").realName("Styk. FHU Sikorzynski P.").nip("7121565822").address("Kowalska 11, 20-115 Lublin").coordinates(new Coordinates("51.249641","22.568212")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RADEK").realName("Radek").address("Luszczow Drugi 43b, 20-258 Luszczow Drugi").coordinates(new Coordinates("51.292213","22.765319")).info("Tel do Radka +48 691 524 604").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA ZANA").realName("Sklep Zabka").nip("9462290333").address("Tomasza Zana 43, 20-834 Lublin").coordinates(new Coordinates("51.237637","22.528316")).info("Towar dostarczamy glownym wejsciem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("EWELINA").realName("EWELINA Wieslaw Rauch").nip("7120066531").address("Prosta 22, 20-400 Lublin").coordinates(new Coordinates("51.265671","22.583035")).info("tel. przed dostawa. Glowne wejscie. Lokal w podworzu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA POLNOCNA").realName("Sklep Zabka").nip("9462538589").address("Polnocna 6, 20-400 Lublin").coordinates(new Coordinates("51.255295","22.562273")).info("Towar dostarczamy glownym wejsciem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PERLA BERNARDYNSKA").realName("Browary Perla").nip("7120103404").address("Bernardynska 15, 20-109 Lublin").coordinates(new Coordinates("51.243506","22.567873")).info("Towar przewaznie dostarczamy do ochrony zaraz za brama po prawej stronie. Prawdopodobnie ochroniarz wysle po podpis dokumentow w inne miejsce. Wychodzimy z bramy i idzemy pod gore do bramy do APARTAMENTY. Wchodzimy w brame i skrecamy od razu w prawo i idziemy na sama gore do biura. Tam prosimy o podpis dokumentow.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BIALCON OLIMP").realName("Rabarbar - sukienki & odziez damska").nip("7121624370").address("34, Aleja Spoldzielczosci Pracy 30, 20-147 Lublin").coordinates(new Coordinates("51.265964","22.572033")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA AKADEMICKA").realName("Sklep Zabka").nip("7132456404").address("Akademicka 1-3, 20-039 Lublin").coordinates(new Coordinates("51.247006","22.542662")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA MEDALIONOW").realName("Sklep Zabka").nip("7133082443").address("Medalionow 8, 20-470 Lublin").coordinates(new Coordinates("51.215964","22.545875")).info("Towar dostarczamy glownym wejsciem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA TURKUSOWA").realName("Sklep Zabka").nip("7133082443").address("Turkusowa 2, 20-400 Lublin").coordinates(new Coordinates("51.224294","22.510157")).info("Towar wnosimy glownym wejsciem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PIEK ART").realName("Piek-Art s.c.").nip("7123062752").address("Rapackiego 20, 20-150 Lublin").coordinates(new Coordinates("51.272961","22.564417")).info("rampa/ glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PIZZERIA WLOSKA PIWNICA").realName("Pizzeria Wloska Piwnica").nip("9462331546").address("Jozefa Pankiewicza 28, 20-400 Lublin").coordinates(new Coordinates("51.261240","22.585003")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("POLSKI DROB").realName("Polski drob").nip("7123296993").address("aleja Armii Krajowej 20, 21-040 Swidnik").coordinates(new Coordinates("51.218195","22.717083")).info("Idziemy do biura glownymi drzwiami na prawo pokoj. Tam po prawej powinna siedziec Pani ktora zajmuje sie przyjmowaniem towaru od Nas. Ta pani rowniez powie gdzie wyladowac towar.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("AQUA").realName("Rest. Prosto z mostu").nip("7122334094").address("Aleje Zygmuntowskie 4, 20-001 Lublin").coordinates(new Coordinates("51.236969","22.568680")).info("Towar dostarczamy od strony fragmentu basenu przeszklonego z wyjsciem na zewnatrz na basenie Aqua. Po lewej stronie jest zjazd w dol a tam drzwi. Stojac przed glownym wejsciem ten zjazd jest po prawej stronie budynku").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ELWIX").realName("Elwix").nip("7120160098").address("Aleja Krasnicka 248, 20-718 Lublin").coordinates(new Coordinates("51.216519","22.456516")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("WETERYNARZ REX").realName("Przychodnia weterynaryjna REX").nip("7123221601").address("Leonarda 3 A, 20-625 Lublin").coordinates(new Coordinates("51.216529","22.456518")).info("boczne drzwi z tylu budynku").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PUBLIMAR").realName("Publimar").nip("7122306086").address("Zwiazkowa 10, 20-150 Lublin").coordinates(new Coordinates("51.269212","22.567920")).info("Worki- ostatnia rampa, paczki - rampa w rogu").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("STREFA").realName("Strefa Gym & Fitness").nip("7123316170").address("Tomasza Zana 19, 20-601 Lublin").coordinates(new Coordinates("51.241167","22.519156")).info("Towar dostarczamy na recepcje do Silowni Strefa na pierwszym pietrze na przeciwko kas w Leclercu. Towar mozna rowniez dostarczyc od parkingu podziemnego winda na lewo od wejscia podziemnego").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("FRYZJER WALLENRODA").realName("Salon Fryzjerski Renata Zarzecka").nip("9461728052").address("Konrada Wallenroda 13, 20-607 Lublin").coordinates(new Coordinates("51.242312","22.525038")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RESTAURACJA PRZYSTAN").realName("Restauracja Przystan").nip("7120201331").address("Wladyslawa Kunickiego 143, 20-451 Lublin").coordinates(new Coordinates("51.215743","22.580475")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RETOR").realName("Retor").nip("9462403642").address("Krochmalna 12, 20-401 Lublin").coordinates(new Coordinates("51.227187","22.555418")).info("wjazd ul. Spoldzielcza 1 brama prawa strona- dzwonek").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RK NIEDZIALEK").realName("RK Niedzialek").nip("9462241576").address("Zwiazkowa 4, 20-150 Lublin").coordinates(new Coordinates("51.269419","22.570174")).info("wjazd od ulicy zwiazkowej na magazyn").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SABAT").realName("Sabat Sp. z o. o.").nip("9462069108").address("Budowlana 24, 20-469 Lublin").coordinates(new Coordinates("51.208576","22.561811")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SABINA").realName("SALON MEDYCZNY SABINA").nip("7131056849").address("Targowa 9 lokal 14, 21-040 Swidnik").coordinates(new Coordinates("51.222407","22.699959")).info("glowne wejscie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RAFAELLO").realName("Rafaello").address("Bursztynowa 1, 20-501 Lublin").coordinates(new Coordinates("51.224392","22.504765")).info("Towar wnosimy od strony garazy na rampe").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("Selgros").realName("Hurtownia Selgros").address("Jana Pawla II 59, 20-535 Lublin").coordinates(new Coordinates("51.227917","22.477432")).info("Odbieramy tam towar. Ustawiamy sie przy bocznej scianie budynku. Idziemy do okienka za kasami w waskim korytarzu na przeciwko kantoru").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("STS").realName("STS P.W. StanisÄąÂ‚aw Szymanek").address("Zimna 5, 20-204 Lublin").coordinates(new Coordinates("51.253293","22.607907")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA PULAWY").realName("Sklep Zabka").address("Hugona Kollataja 18F, 24-100 Pulawy").coordinates(new Coordinates("51.419873","21.953224")).route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("PAN TOMEK RZESZOW").realName("Prawdopodobnie Tania odziez").address("Langiewicza 18, 35-021 Rzeszow").coordinates(new Coordinates("50.031330","21.987321")).info("Dawne zaklady Zelmer, tel. 663 399 511").route(new Route("Rzeszow")).build());
        saveClient(Client.builder().warehouseName("SPIZARNIA").realName("Magazyn Spizarnia").address("Jozefa Franczaka Lalka 12, 20-325 Lublin").coordinates(new Coordinates("51.222217","22.620557")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SKLADNICA").realName("AGENCJA REZERW MATERIALNYCH").address("droga z niemcow na jawidz").coordinates(new Coordinates("51.361362","22.658391")).route(new Route("Lubartów")).build());
        saveClient(Client.builder().warehouseName("BIURPACK").realName("Biurpack Express").nip("8212463855").address("Juliusza Slowackiego 54, 21-100 Lubartow").coordinates(new Coordinates("51.471756","22.606896")).info("Towar ukladamy na paletach przed sklepem").route(new Route("Lubartów/ Parczew")).build());
        saveClient(Client.builder().warehouseName("5").realName("Sklep Gamma").nip("5632423737").address("Ul. Sloneczna 8A Rejowiec").coordinates(new Coordinates("51.098831","23.275258")).route(new Route("Chełm")).build());
        saveClient(Client.builder().warehouseName("WEDLINKA").realName("Sklep miesny Wedlinka").coordinates(new Coordinates("51.235070","22.510326")).build());
        saveClient(Client.builder().warehouseName("LOCOMOTIVA").realName("Hotel Locomotiva").nip("7122367662").address("Ulica Polnocna 28c, 20-064 Lublin").coordinates(new Coordinates("51.254155","22.556756")).info("Wejscie na kuchnie na koncu parkingu.").build());
        saveClient(Client.builder().warehouseName("FoodWork Jaroslaw Kurowski").realName("Garmazerka").address("Partyzancka 3A, 24-220 Niedrzwica Duza").coordinates(new Coordinates("51.113467","22.391569")).route(new Route("Kraśnik")).build());
        saveClient(Client.builder().warehouseName("Lubinowe Wzgorze MONIKA URBAN").realName("Lubinowe Wzgorze, Eko Resort and Natural SPA").nip("6761617349").address("Laki 45A, 24-160 Laki").coordinates(new Coordinates("51.282300","22.182348")).route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("U szwagra").realName("lokal Felix w Outlet Center").nip("9222624042").address("Melgiewska 16D, 20-234 Lublin").coordinates(new Coordinates("51.246842","22.618127")).info("Towar dostarczamy do lokalu Felix w Outlet Center. Malym samochodem mozna wjechac na parking podziemny centralnie pod strefe gastronomiczna").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("Utylimed").realName("Utylimed- zarzadzanie odpadami").address("Turystyczna 9, 20-001 Lublin").coordinates(new Coordinates("51.254436","22.604361")).info("wejscie z boku budynku przeszklone. Z faktura na gore do Popka. a towar przy schodach zostawiamy").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SOLIDARNOSCI TBV HOTELE").realName("Hotel Ibis").address("Aleja Solidarnosci 7, 20-841 Lublin").coordinates(new Coordinates("51.252809","22.564858")).info("Glowne wejscie i idziemy na kuchnie z towarem").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PIZZA LOVER").realName("Pizzeria Pizza Lover").nip("9212035278").address("Nowy Swiat 41A, Lublin").coordinates(new Coordinates("51.224015","22.556971")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("DZIKI WSCHOD").realName("Restauracja Dziki Wschod").nip("7123256947").address("Jasna 7, 20-077 Lublin").coordinates(new Coordinates("51.248483","22.553282")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA STAFFA").realName("Sklep Zabka").nip("7121680196").address("Leopolda Staffa 20A, 20-960 Lublin").coordinates(new Coordinates("51.208729","22.582422")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MARKET BUGALA ODLEWNICZA").realName("Sklep Malwa").nip("7121019249").address("Odlewnicza 10, 20-219 Lublin").coordinates(new Coordinates("51.246864","22.595474")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SZKOLA SWIDNIK FOOD").realName("Szkola podst. nr 7").nip("7010252178").address("aleja Armii Krajowej 3, 21-040 Swidnik").coordinates(new Coordinates("51.216199","22.713525")).info("Wjezdzamy na parking szkoly pomiedzy kosz a budek szkoly w strefie dostaw. Towar znosimy na dol lub na gore, a podpis bierzemy na gorze po prawo w biurze u Pani").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PONENTINO").realName("Pizzeria Ponentino").nip("7123388494").address("Skowronkowa 100, 21-002 Lublin").coordinates(new Coordinates("51.283589","22.496511")).info("Towar dostarczamy do prywatnego domu, a dokladnie do namiotu z piecem przed domem.Pies, ktory biega podobno nie gryzie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TANIA ODZIEZ WRONSKA").realName("Sklep Tania odziez").nip("7130015104").address("Wronska 2, 20-300 Lublin").coordinates(new Coordinates("51.234995","22.581871")).info("Towar dostarczamy z tylu budynku, ostatnie drzwi po lewej stronie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BOMBARDINO BOTANIK").realName("Restauracja Bombardino Botanik").nip("7122681476").address("Slawinkowska 15, 20-800 Lublin").coordinates(new Coordinates("51.267642","22.512445")).info("Towar wnosimy drzwiami od hotelu i znosimy na dol na kuchnie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LIFT SERVICE").realName("Lubelska Wytwornia Dzwigow Osobowych LIFT SERVICE").nip("7120102876").address("Erazma Plewinskiego 22, 20-270 Lublin").coordinates(new Coordinates("51.228930","22.639889")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA DRAGONOW").realName("Sklep Zabka").nip("5512285741").address("Ulanow, 20-554 Lublin").coordinates(new Coordinates("51.235878","22.504806")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KIOSK DASZYNSKIEGO").realName("Kiosk").nip("7122374099").address("Daszynskiego, Lublin").coordinates(new Coordinates("51.260772","22.596062")).info("Lokalizacja orienacyjna. Mozna poprawic jak ktos znajdzie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ECO TEAM").realName("Eco-Team").nip("7122790952").address("Grenadierow 13/lok 208, 20-331 Lublin").coordinates(new Coordinates("51.234773","22.618879")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BDS").realName("B.D.S. Sp. z o. o.").nip("946-23-13-838").address("Garbarska 16, 20-340 Lublin").coordinates(new Coordinates("51.233572","22.579430")).info("Wspolrzedne ustawione sa na plac gdzie odbieramy towar. Natomiast po zamowienie trzeba pojsc do biura ktore znajduje sie od strony ulicy na koncu budynku").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("WLASNEJ ROBOTY").realName("Delikatesy Wlasnej Roboty - Zdrowa Zywnosc").nip("7123345102").address("Tadeusza Kosciuszki 5, 20-006 Lublin").coordinates(new Coordinates("51.247006","22.559790")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LUCREATE").realName("Fundacja Rozwoju Designu LuCreate").nip("7123285624").address("Krakowskie Przedmiescie 53, 20-418 Lublin").coordinates(new Coordinates("51.247736","22.552858")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BEZZZ CAFE").realName("BEZZZ CAFE").nip("9462511194").address("Lubartowska 23, 20-400 Lublin").coordinates(new Coordinates("51.249537","22.566700")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PIOTRUS PAN").realName("Bar Piotrus Pan").nip("7121084525").address("Kowalska 11, 20-115 Lublin").coordinates(new Coordinates("51.249736","22.569064")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TABAL").realName("Tabal").nip("7120101121").address("Energetykow 14, 20-468 Lublin").coordinates(new Coordinates("51.207848","22.553047")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("16 STOLOW").realName("16 stolow").address("Rynek 16/1, 20-001 Lublin").coordinates(new Coordinates("51.247636","22.567898")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("KAWA I LAWA").realName("Kawa i lawa").nip("7122693189").address("Zygmunta Krasinskiego 11, 20-709 Lublin").coordinates(new Coordinates("51.242147","22.511944")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZABKA ULANOW").realName("Sklep Zabka").nip("5512285741").address("Ulanow 35, 20-554 Lublin").coordinates(new Coordinates("51.236074","22.499722")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MUNCHIES").realName("Munchies Lublin").nip("9462482392").address("Hugona Kollataja 5, 20-400 Lublin").coordinates(new Coordinates("51.246974","22.557998")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("TAKT").realName("Takt - hurtownia srodkow czystosci").nip("7120251777").address("Cisowa 1, 20-701 Lublin").coordinates(new Coordinates("51.250842","22.512171")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SZWEJK FELICITY FELIN").realName("Restauracja Szwejk").nip("7123106745").address("aleja Wincentego Witosa 32, 20-315 Lublin").coordinates(new Coordinates("51.232394","22.615462")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BARON").realName("B i M Baron s.c.").nip("7123097874").address("Jasna 7, 20-077 Lublin").coordinates(new Coordinates("51.248480","22.553140")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZLOTY KURCZAK WILENSKA").realName("Zloty Kurczak").nip("7120306395").address("Wilenska 21, 20-603 Lublin").coordinates(new Coordinates("51.242248","22.518256")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("RANCH BURGER").realName("Ranch Burger and pizza").nip("7123375698").address("Zbozowa 16, 20-827 Lublin").coordinates(new Coordinates("51.269391","22.505204")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("GRZES").realName("Sklep Wielobranzowy Grzes").nip("7121491087").address("aleja Warszawska 97, Lublin 20-824").coordinates(new Coordinates("51.262770","22.506230")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("DOMINIUM ORKANA").realName("Pizza Dominium").nip("5252415619").address("Galeria Orkana, Orkana 6, 20-504 Lublin").coordinates(new Coordinates("51.234177","22.494900")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZIELONY TALERZYK").realName("Restauracja Zielony Talerzyk").nip("7141855552").address("Krolewska 3, 20-109 Lublin").coordinates(new Coordinates("51.247048","22.565962")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("PACZEK").realName("Sklep spozywczy Paczek").nip("7122475179").address("Szmaragdowa 24, 20-570 Lublin").coordinates(new Coordinates("51.226807","22.518768")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("ZIARENKO").realName("Przedszkole Ziarenko").nip("5631772068").address("Bursztynowa 20, 20-576 Lublin").coordinates(new Coordinates("51.223358","22.517465")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("GARMAZERKA TURKA").realName("Garmazerka Top Market").nip("9462640744").address("Bukowa 2, 20-258 Lublin").coordinates(new Coordinates("51.277960","22.658728")).info("Towar dostarczamy z prawej strony od glownego wejscia do top marketu. Idziemy po schodkach i na kuchni zostawiamy towar").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("CREDO").realName("Credo").nip("5372016514").address("Nadbystrzycka 8, 20-506 Lublin").coordinates(new Coordinates("51.238393","22.551961")).info("Punkt znajduje sie za apteka").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("WOC FOODTRUCK").realName("Foodtruck").nip("9462680732").address("Zana 41, 20-601 Lublin").coordinates(new Coordinates("51.237992","22.528703")).info("To jest foodtruck przy rondzie kolo zusu na Zana. Najlepiej podjechac od parkingu przy banku ING").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BLAKO PARTYZANTOW").realName("Hotel Prima").nip("7162822960").address("Aleja Partyzantow 44, 24-100 Pulawy").coordinates(new Coordinates("51.424202","21.983267")).route(new Route("Puławy")).build());
        saveClient(Client.builder().warehouseName("ZATAR WOJCIK SOLNA").realName("ZATAR mezze and hummus and grill").nip("7122929545").address("Solna 4/2, Lublin").coordinates(new Coordinates("51.244637","22.555163")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("MANUFAKTURA").realName("Manufaktura").nip("7123314308").address("ul. Spokojna 2, 20-074 Lublin").coordinates(new Coordinates("51.249861","22.553174")).info("Duzy przeszklony budynek ").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("SZTUKA I RZEMIOSLO").realName("Sztuka i Rzemioslo").nip("946006753").address("Niccolo Paganiniego 17, 20-850 Lublin").coordinates(new Coordinates("51.257606","22.551906")).info("Towar dostarczamy glownym wejsciem. Pani na kamerach ogarnie ze wchodzimy i pokaze gdzie zostawic towar.").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("BELMET").realName("Firma handlowa Belmet-1").nip("7121086234").address("ul. Kowalska 4, 20-115 Lublin").coordinates(new Coordinates("51.249892","22.567705")).route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("LUX 28").realName("Sklep PSS Spolem").nip("5380002490").address("Bialka 152").coordinates(new Coordinates("51.811004","22.663865")).info("Wejscie za budynkiem, od zaplecza").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 20").realName("Sklep PSS Spolem").nip("5380002490").address("Miedzyrzecka 77, 21-300 Radzyn Podlaski").coordinates(new Coordinates("51.793998","22.629639")).info("wejscie po lewej na koncu budynku").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 8").realName("PSS Spolem").nip("5380002490").address("Ostrowiecka 12, 21-300 Radzyn Podlaski").coordinates(new Coordinates("51.782937","22.620106")).info("glowne wejscie").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 17/BIURO").realName("PSS Spolem").nip("5380002490").address("Warszawska 1521-300 Radzyn Podlaski").coordinates(new Coordinates("51.782226","22.616406")).info("wjazd w brame, wejscie na rampie").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 1").realName("PSS Spolem").nip("5380002490").address("Ostrowiecka 13, 21-300 Radzyn Podlaski").coordinates(new Coordinates("51.782763","22.617293")).info("wejscie od tylu ulica warszawska").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 22").realName("PSS Spolem").nip("5380002490").address("Ostrowiecka 9,21-300 Radzyn Podlaski").coordinates(new Coordinates("51.782781","22.618212")).info("wejscie od tylu ulica warszawska").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 6").realName("PSS Spolem").nip("5380002490").address("Ostrowiecka 9,21-300 Radzyn Podlaski").coordinates(new Coordinates("51.782781","22.618212")).info("wejscie od tylu ulica warszawska").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 25").realName("PSS Spolem").nip("5380002490").address("Sitkowskiego 4,21-300 Radzyn Podlaski").coordinates(new Coordinates("51.778585","22.627603")).info("wjazd w brame po prawej stronie budynku").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 21").realName("PSS Spolem").nip("5380002490").address("Warszawska 34,21-300 Radzyn Podlaski").coordinates(new Coordinates("51.782800","22.611544")).info("wjazd za budynek, mala rampa po schodkach").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("LUX 27").realName("PSS Spolem").nip("5380002490").address("Wyszynskiego 14,21-300 Radzyn Podlaski").coordinates(new Coordinates("51.776807","22.608933")).info("zjazd w dol za budynkiem - rampa").route(new Route("Radzyn")).build());
        saveClient(Client.builder().warehouseName("POSTER NARUTOWICZA").realName("Kiosk").nip("7120253026").address("Narutowicza 11, Lublin").coordinates(new Coordinates("51.246854","22.562785")).info("glowne wjescie").route(new Route("Lublin")).build());
        saveClient(Client.builder().warehouseName("COLOR PACK").realName("Color pack").nip("9662099321").address("Przedzalniana 8, 15-688 Bialystok").coordinates(new Coordinates("53.158103","23.080411")).info("Magazyn czynny 8-16. Dzwonic do Kamila na miejscu.570 016 016").route(new Route("Bialystok")).build());
        saveClient(Client.builder().warehouseName("MIT Malgorzata Kowalska").realName("Sklep spozywczy").nip("9461914636").address("Zabia Wola 66B, 23-107 Zabia Wola").coordinates(new Coordinates("51.122975","22.515775")).info("glowne wejscie").route(new Route("Łęczna")).build());

        routeService.findAll().forEach(System.out::println);

        List<Client> clients = clientService.findAll();

        clients.forEach(System.out::println);

    }

    public void saveClient(Client client){

        if (client != null){
            if (client.getRoute()!=null){
                client.getRoute().getClients().add(client);

                Optional<Route> routeOptional = routeService.findByName(client.getRoute().getName());
                Route route = routeOptional.orElseGet(() -> routeService.save(client.getRoute()));
                client.setRoute(route);
            }
            if (client.getCoordinates() != null){
                client.getCoordinates().setClient(client);
            }

            clientService.save(client);
        }

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
                .created(LocalDateTime.now())
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
