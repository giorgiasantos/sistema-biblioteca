package com.estudos.sistemabiblioteca.service;

import com.estudos.sistemabiblioteca.model.Livros;
import com.estudos.sistemabiblioteca.repo.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {
    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livros> findAllLivros(){
        return livrosRepository.findAll();
    }

    public Optional<Livros> findLivroById(Long id){
        Optional<Livros> livro = livrosRepository.findById(id);

        if(livro.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(livro.get());
    }

    public Optional<List<Livros>> findLivroByTitulo(String titulo){
        Optional<List<Livros>> livro = livrosRepository.findLivroByTitulo(titulo);

        if(livro.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(livro.get());
    }

    public Livros createLivro(Livros livro){
        return livrosRepository.save(livro);
    }

    public Livros editLivro(Livros livro, Long id){
        Livros livroEditado = livrosRepository.findById(id).get();

        if(livroEditado != null) {
            livroEditado.setTitulo(livro.getTitulo());
        }
        if(livroEditado != null){
            livroEditado.setAutor(livro.getAutor());
        }
        if(livroEditado != null){
            livroEditado.setIsbn(livro.getIsbn());
        }
        if(livroEditado != null){
            livroEditado.setGenero(livro.getGenero());
        }
        if(livroEditado != null){
            livroEditado.setDisponivel(livro.isDisponivel());
        }

        return livrosRepository.save(livroEditado);
    }

    public void deleteLivro(Long id) {
        livrosRepository.deleteById(id);
    }

}
