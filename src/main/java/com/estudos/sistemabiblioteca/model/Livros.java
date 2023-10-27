package com.estudos.sistemabiblioteca.model;

import com.estudos.sistemabiblioteca.enums.Genero;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String autor;

    private String isbn;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @NotNull
    private boolean disponivel;

    @ManyToMany(mappedBy = "livros")
    private List<Emprestimos> historicoEmprestimos;

    public Livros(Long id, String titulo, String autor, String isbn, Genero genero, boolean disponivel, List<Emprestimos> historicoEmprestimos) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.disponivel = disponivel;
        this.historicoEmprestimos = historicoEmprestimos;
    }

    public Livros() {
    }
}
