package siedlecki.mateusz.c2capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","","/index.html"})
public class MainController {

    @GetMapping
    public String mainMenu(){
        return "index";
    }
}
