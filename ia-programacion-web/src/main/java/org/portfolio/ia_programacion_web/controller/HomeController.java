package org.portfolio.ia_programacion_web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    
}
