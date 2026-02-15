package org.portfolio.ia_programacion_web.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 5, max = 100, message = "El título debe tener entre 5 y 100 caracteres")
    private String title;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Size(min = 20, message = "El contenido debe tener al menos 20 caracteres")
    @Column(length = 5000)
    private String content;

    private LocalDate createdAt;

    public void setId(Long id) {
        this.id = id;
    }


    // Constructor vacío (OBLIGATORIO para JPA)
    public Article() {
        this.createdAt = LocalDate.now();
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
