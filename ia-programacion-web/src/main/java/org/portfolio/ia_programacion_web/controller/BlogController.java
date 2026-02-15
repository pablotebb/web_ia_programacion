package org.portfolio.ia_programacion_web.controller;

import org.portfolio.ia_programacion_web.model.Article;
import org.portfolio.ia_programacion_web.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

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

    @GetMapping("/blog/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artículo no encontrado"));

        model.addAttribute("article", article);
        return "article-form";
    }

    @PostMapping("/blog/update/{id}")
    public String updateArticle(@PathVariable Long id,
                                @Valid @ModelAttribute Article article,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "article-form";
        }

        article.setId(id);
        articleRepository.save(article);

        return "redirect:/blog";
    }


    @GetMapping("/blog/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/blog";
    }

    @PostMapping("/blog")
    public String saveArticle(@Valid @ModelAttribute Article article,
                            BindingResult result,
                            Model model) {

        if (result.hasErrors()) {
            return "article-form";
        }

        articleRepository.save(article);
        return "redirect:/blog";
    }




}
