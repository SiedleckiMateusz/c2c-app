package siedlecki.mateusz.c2capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import siedlecki.mateusz.c2capp.service.client.ClientService;

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
        model.addAttribute("client",clientService.findById(Long.parseLong(id)).orElse(null));

        return "clients/detalis";
    }
}
