package org.portfolio.ia_programacion_web.controller;

import org.portfolio.ia_programacion_web.model.Article;
import org.portfolio.ia_programacion_web.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
/* import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
 */
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/blog/{id}")
    public String articleDetail(@PathVariable Long id, Model model) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artículo no encontrado"));

        model.addAttribute("article", article);
        return "article-detail";
    }

    @GetMapping("/blog/new")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new Article());
        return "article-form";
    }

    @PostMapping("/blog")
    public String createArticle(@ModelAttribute Article article) {
        articleRepository.save(article);
        return "redirect:/blog";
    }


}
