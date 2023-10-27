package com.estudos.sistemabiblioteca.repo;

import com.estudos.sistemabiblioteca.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivrosRepository extends JpaRepository<Livros,Long> {
    @Query("SELECT titulo FROM Livros titulo WHERE LOWER (titulo.titulo) = LOWER(:titulo)")
    Optional<List<Livros>> findLivroByTitulo(String titulo);

    @Query("SELECT autor FROM Livros autor WHERE LOWER (autor.autor) = LOWER(:autor)")
    Optional<List<Livros>> findLivroByAutor(String autor);

    @Query("SELECT genero FROM Livros genero WHERE LOWER (genero.genero) = LOWER(:genero)")
    Optional<List<Livros>> findLivroByGenero(String genero);

}
