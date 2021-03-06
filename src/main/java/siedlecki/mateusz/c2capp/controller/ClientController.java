package siedlecki.mateusz.c2capp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siedlecki.mateusz.c2capp.controller.mapper.client.ClientMapper;
import siedlecki.mateusz.c2capp.controller.model.client.ShowClient;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;
import siedlecki.mateusz.c2capp.entity.client.CoordinatesEntity;
import siedlecki.mateusz.c2capp.entity.client.RouteEntity;
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
    private final ClientMapper clientMapper;


    public ClientController(ClientService clientService, RouteService routeService, CoordinatesService coordinatesService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.routeService = routeService;
        this.coordinatesService = coordinatesService;
        this.clientMapper = clientMapper;
    }

    @GetMapping(value = {""})
    public String getAll(Model model){
        List<ShowClient> clients = clientService.findAllToShow();
        clients.forEach(System.out::println);
        model.addAttribute("clients",clients);

        return "clients/index";
    }

    @GetMapping({"/find"})
    public String findByText(Model model, @RequestParam(name = "text") String text){
        List<ShowClient> resultsList = new ArrayList<>();

        if (text != null){
            resultsList = clientService.findAllBySentence(text);
        }

        model.addAttribute("clients",resultsList);

        return "clients/index";

    }

    @GetMapping({"/{id}"})
    public String getById(Model model,@PathVariable String id){
        ClientEntity client = null;

        try{
            client = clientService.findById(Long.parseLong(id)).orElse(null);

        }catch (NumberFormatException e){
            log.error("Nieprawidłowy format wartości Long");
        }

        ShowClient showClient = clientMapper.entityToShow(client);
        model.addAttribute("client",showClient);
        log.info("Zwracam stronę detalis.html z obiektem: "+showClient);
        return "clients/detalis";
    }

    @GetMapping("/new")
    public String newClient(){

        return "clients/form";
    }

    @GetMapping("/new/{pathCoordinates}")
    public String newClientWithCoordinates(Model model,@PathVariable String pathCoordinates){

        String[] coordinatesTab = pathCoordinates.split("_");

        CoordinatesEntity coordinates = new CoordinatesEntity(coordinatesTab[0],coordinatesTab[1]);

        ClientEntity client = ClientEntity.builder().coordinates(coordinates).build();

        model.addAttribute("client",client);

        return "clients/form";
    }

    @GetMapping("/edit/{id}")
    public String editClient(Model model, @PathVariable String id){

        model.addAttribute("client",clientService.findById(Long.parseLong(id)).orElse(null));

        return "clients/form";
    }

    @GetMapping("/remove/{id}")
    public void removeClientById(@PathVariable String id, HttpServletResponse response) throws IOException {

        clientService.deleteById(Long.parseLong(id));

        response.sendRedirect("/clients/");
    }

    @PostMapping(value = {"/",""})
    public String addNewClient(@ModelAttribute ClientEntity client){

        RouteEntity route = null;

        if (!client.getRoute().getName().isEmpty()){
            Optional<RouteEntity> routeOptional = routeService.findByName(client.getRoute().getName());
            route = routeOptional.orElseGet(() -> routeService.save(new RouteEntity(client.getRoute().getName())));

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


        return "redirect:/clients/";
    }

}
