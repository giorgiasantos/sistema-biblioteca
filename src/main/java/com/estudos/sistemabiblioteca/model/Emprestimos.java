package com.estudos.sistemabiblioteca.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Emprestimos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate dataEmprestimo;
    @NotNull
    private LocalDate dataEntrega;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "emprestimo_livro",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livros> livros;

    public Emprestimos(Long id, LocalDate dataEmprestimo, LocalDate dataEntrega, List<Livros> livros) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataEntrega = dataEntrega;
        this.livros = livros;
    }

    public Emprestimos() {
    }

}
