package org.portfolio.ia_programacion_web.controller;

import org.portfolio.ia_programacion_web.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    private final ArticleRepository articleRepository;

    public BlogController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "blog";
    }
}
