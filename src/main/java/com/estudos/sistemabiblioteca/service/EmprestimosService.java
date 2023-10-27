package com.estudos.sistemabiblioteca.service;

import com.estudos.sistemabiblioteca.dtos.EmprestimosDTO;
import com.estudos.sistemabiblioteca.model.Emprestimos;
import com.estudos.sistemabiblioteca.model.Livros;
import com.estudos.sistemabiblioteca.repo.EmprestimosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimosService {

    @Autowired
    private EmprestimosRepository emprestimosRepository;
    @Autowired
    private LivrosService livrosService;

    public List<Emprestimos> getAllEmprestimos(){
        return emprestimosRepository.findAll();
    }

    public Optional<Emprestimos> findEmprestimoById(Long id){
        Optional<Emprestimos> emprestimo = emprestimosRepository.findById(id);

        if(emprestimo.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(emprestimo).get();
    }

    public Emprestimos createEmprestimo (EmprestimosDTO emprestimosDTO){

        Emprestimos emprestimos = new Emprestimos();
        List<Livros> livros = livrosService.findLivrosById(emprestimosDTO.getLivrosIds());
        for(Livros livro: livros) {
            livro.setDisponivel(false);
            livrosService.editLivro(livro,livro.getId());
        }
        emprestimos.setLivros(livros);
        emprestimos.setDataEmprestimo(emprestimosDTO.getDataEmprestimo());
        emprestimos.setDataEntrega(emprestimosDTO.getDataEntrega());
        return emprestimosRepository.save(emprestimos);
    }

    public void closeEmprestimo(Long idEmprestimo) {
        Emprestimos emprestimo = emprestimosRepository.findById(idEmprestimo).orElseThrow( () -> new RuntimeException("Empréstimo não encontrado."));

        for(Livros livro:emprestimo.getLivros()){
            livro.setDisponivel(true);
            livro.setHistoricoEmprestimos(List.of(emprestimo));
            livrosService.editLivro(livro,livro.getId());
        }
    }
}
