package br.com.etecweb.etecweb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/etecweb")
public class EtecWebController {
   
    @GetMapping
    public String index(Model model){
        //retorna a pagina index.html
        return "index";
    }
}