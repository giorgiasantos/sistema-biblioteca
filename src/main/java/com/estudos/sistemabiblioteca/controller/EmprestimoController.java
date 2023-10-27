package com.estudos.sistemabiblioteca.controller;

import com.estudos.sistemabiblioteca.dtos.EmprestimosDTO;
import com.estudos.sistemabiblioteca.model.Emprestimos;
import com.estudos.sistemabiblioteca.repo.EmprestimosRepository;
import com.estudos.sistemabiblioteca.service.EmprestimosService;
import com.estudos.sistemabiblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimosService emprestimosService;
    @Autowired
    private LivrosService livrosService;

    @GetMapping
    public List<Emprestimos> getAllEmprestimos(){
        return emprestimosService.getAllEmprestimos();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findEmprestimoById(@PathVariable Long id){
        Optional<Emprestimos> emprestimos = emprestimosService.findEmprestimoById(id);

        if(emprestimos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emprestimos);

    }

    @PostMapping
    public ResponseEntity<?> criateEmprestimo(@RequestBody EmprestimosDTO emprestimos){
        Emprestimos novoEmprestimo = emprestimosService.createEmprestimo(emprestimos);
        return ResponseEntity.ok().body(novoEmprestimo);
    }

    @PutMapping(path = "/{id}/encerrar")
    public ResponseEntity<?> closeEmprestimo(@PathVariable Long id){
        emprestimosService.closeEmprestimo(id);

        return ResponseEntity.ok().body("O emprestimo foi encerrado com sucesso!");
    }


}
