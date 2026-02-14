package org.portfolio.ia_programacion_web.repository;

import org.portfolio.ia_programacion_web.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
