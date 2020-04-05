package siedlecki.mateusz.c2capp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.client.Coordinates;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.service.client.ClientService;
import siedlecki.mateusz.c2capp.service.client.CoordinatesService;
import siedlecki.mateusz.c2capp.service.client.RouteService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequestMapping({"/clients","/clients.html"})
public class ClientController {

    private final ClientService clientService;
    private final RouteService routeService;
    private final CoordinatesService coordinatesService;


    public ClientController(ClientService clientService, RouteService routeService, CoordinatesService coordinatesService) {
        this.clientService = clientService;
        this.routeService = routeService;
        this.coordinatesService = coordinatesService;
    }

    @RequestMapping({"/",""})
    public String getAll(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients",clients);

        model.addAttribute("coords",getCoordinatesForMap(clients));

        return "clients/index";
    }

    @GetMapping({"/find","/"})
    public String findByText(Model model, @RequestParam(name = "text") String text){
        List<Client> resultsList = new ArrayList<>();

        if (text != null){
            resultsList = clientService.findAllBySentence(text);
        }

        model.addAttribute("clients",resultsList);

        model.addAttribute("coords",getCoordinatesForMap(resultsList));

        return "clients/index";

    }

    @RequestMapping({"/{id}"})
    public String getById(Model model,@PathVariable String id){
        Client client = null;

        try{
            client = clientService.findById(Long.parseLong(id)).orElse(null);

        }catch (NumberFormatException e){
            log.error("Nieprawidłowy format wartości Long");
        }

        model.addAttribute("client",client);
        log.info("Zwracam stronę detalis.html z obiektem: "+client);
        return "clients/detalis";
    }

    @RequestMapping("/new")
    public String newClient(){

        return "clients/form";
    }

    @RequestMapping("/new/{pathCoordinates}")
    public String newClientWithCoordinates(Model model,@PathVariable String pathCoordinates){

        String[] coordinatesTab = pathCoordinates.split("_");

        Coordinates coordinates = new Coordinates(coordinatesTab[0],coordinatesTab[1]);

        Client client = Client.builder().coordinates(coordinates).build();

        model.addAttribute("client",client);

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
    public String addNewClient(@ModelAttribute Client client){

        Route route = null;

        if (!client.getRoute().getName().isEmpty()){
            Optional<Route> routeOptional = routeService.findByName(client.getRoute().getName());
            route = routeOptional.orElseGet(() -> routeService.save(new Route(client.getRoute().getName())));

        }

        client.setRoute(route);

        if (route != null){
            route.getClients().add(client);
        }

        if (!client.getCoordinates().getX().isEmpty() && !client.getCoordinates().getY().isEmpty()){
            client.getCoordinates().setClient(client);
        }else {
            if (client.getCoordinates().getId() != null){
                coordinatesService.deleteById(client.getCoordinates().getId());
            }
            client.setCoordinates(null);
        }

        clientService.save(client);


        return "redirect:/clients";
    }


    private List<String> getCoordinatesForMap(List<Client> clients){
        List<String> coordinations = new ArrayList<>();

        for (Client client : clients) {
            if (client.getCoordinates()!=null){
                coordinations.add(client.getId()+";"+client.getWarehouseName()+";"+client.getCoordinates().getX()+";"+client.getCoordinates().getY());
            }
        }

        return coordinations;
    }



}
