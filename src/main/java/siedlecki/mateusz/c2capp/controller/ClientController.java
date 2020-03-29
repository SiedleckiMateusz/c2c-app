package siedlecki.mateusz.c2capp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.client.Coordinates;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.service.client.ClientService;
import siedlecki.mateusz.c2capp.service.client.RouteService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@Slf4j
@Controller
@RequestMapping({"/clients","/clients.html"})
public class ClientController {

    private final ClientService clientService;
    private final RouteService routeService;


    public ClientController(ClientService clientService, RouteService routeService) {
        this.clientService = clientService;
        this.routeService = routeService;
    }

    @GetMapping({"/",""})
    public String getAll(Model model){
        model.addAttribute("clients",clientService.findAll());

        return "clients/index";
    }

    @RequestMapping({"/{id}"})
    public String getById(Model model,@PathVariable String id){
        Client client = null;

        try{
            client = clientService.findById(Long.parseLong(id)).orElse(null);

        }catch (NumberFormatException e){
            log.error("Nieprawidłowy format wartości");
        }


        model.addAttribute("client",client);
        log.info("Zwracam stronę detalis.html z obiektem: "+client);
        return "clients/detalis";
    }

    @RequestMapping("/new")
    public String newClient(Model model){
        model.addAttribute("method","post");
        model.addAttribute("action","/clients");

        return "clients/form";
    }

    @RequestMapping("/edit/{id}")
    public String editClient(Model model, @PathVariable String id){

        model.addAttribute("client",clientService.findById(Long.parseLong(id)).orElse(null));


        return "clients/form";
    }

    @RequestMapping("/remove/{id}")
    public void removeClientById(@PathVariable String id, HttpServletResponse response) throws IOException {

        clientService.deleteById(Long.parseLong(id));

        response.sendRedirect("/clients");
    }

    @RequestMapping(value = {"/",""}, method = RequestMethod.POST)
    public void addNewClient(HttpServletResponse response
            , @RequestParam("warehouseName") String warehouseName
            , @RequestParam("id") String id
            , @RequestParam("coordinate_id") String coordinateId
            , @RequestParam("realName") String realName
            , @RequestParam("x") String x
            , @RequestParam("y") String y
            , @RequestParam("info") String info
            , @RequestParam("route") String routeString
            , @RequestParam("address") String address
            , @RequestParam("nip") String nip
                             ) throws IOException {


        Optional<Route> routeOptional = routeService.findByNameContains(routeString);
        Route route = routeOptional.orElseGet(() -> routeService.save(new Route(routeString)));



        Coordinates coordinates  = new Coordinates(x,y);

        try {
            coordinates.setId(Long.parseLong(coordinateId));
        }catch (NumberFormatException e){
            log.error("Coordinate id is not a number!");
        }catch (NullPointerException e){
            log.error("Coordinate id is null!");
        }

        Client client = Client.builder()
                .warehouseName(warehouseName)
                .realName(realName)
                .info(info)
                .address(address)
                .nip(nip)
                .coordinates(coordinates)
                .route(route)
                .build();

        try {
            client.setId(Long.parseLong(id));
        }catch (NumberFormatException e){
            log.error("Id is not a number!");
        }catch (NullPointerException e){
            log.error("Id is null!");
        }

        route.getClient().add(client);

        coordinates.setClient(client);

        clientService.save(client);

        response.sendRedirect("/clients");
    }



}
