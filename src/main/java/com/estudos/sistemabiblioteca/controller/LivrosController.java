package com.estudos.sistemabiblioteca.controller;

import com.estudos.sistemabiblioteca.model.Livros;
import com.estudos.sistemabiblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @GetMapping
    public List<Livros> findAllLivros(){
        return livrosService.findAllLivros();
    }

    @GetMapping(path = "FindById/{id}")
    public ResponseEntity<?> findLivroById(@PathVariable Long id){
        Optional<Livros> livro = livrosService.findLivroById(id);

        if(livro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping(path = "FindByTitulo/{titulo}")
    public ResponseEntity<?> findLivroByTitulo(@PathVariable String titulo){
        Optional<List<Livros>> livro = livrosService.findLivroByTitulo(titulo);

        if(livro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        return ResponseEntity.ok().body(livro);
    }

    @PostMapping
    public ResponseEntity<?> createNewLivro (@RequestBody Livros livros){

        livrosService.createLivro(livros);

        return  ResponseEntity.status(HttpStatus.CREATED).body("Novo livro cadastrado com sucesso!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> editLivro(@RequestBody Livros livros, @PathVariable Long id){
        livrosService.editLivro(livros,id);

        return ResponseEntity.ok().body("Livro editado com sucesso!");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteLivro(@PathVariable Long id){
        livrosService.deleteLivro(id);
    }
}
