package siedlecki.mateusz.c2capp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.service.client.ClientService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Controller
@RequestMapping({"/clients","/clients.html"})
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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

    @RequestMapping(value = {"/",""}, method = RequestMethod.POST)
    public void addNewClient(HttpServletResponse response
            , @RequestParam("warehouseName") String warehouseName
            , @RequestParam("realName") String realName
            , @RequestParam("x") String x
            , @RequestParam("y") String y
            , @RequestParam("info") String info
                             ) throws IOException {



        response.sendRedirect("/clients");
    }



}
