package siedlecki.mateusz.c2capp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.service.client.ClientService;


@Slf4j
@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping({"/clients","clients.html",""})
    public String getAll(Model model){
        model.addAttribute("clients",clientService.findAll());

        return "clients/index";
    }

    @RequestMapping({"/clients/{id}"})
    public String getAll(Model model,@PathVariable String id){
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
}
