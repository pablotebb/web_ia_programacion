package org.portfolio.ia_programacion_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Inicio");
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(Model model) {
        model.addAttribute("title", "Sobre el proyecto");
        return "sobre";
    }

    @GetMapping("/cursos")
    public String cursos(Model model) {
        model.addAttribute("title", "Cursos");
        return "cursos";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("title", "Contacto");
        return "contacto";
    }

}
