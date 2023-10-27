package com.estudos.sistemabiblioteca.dtos;
import java.time.LocalDate;
import java.util.List;

public class EmprestimosDTO {
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;
    private List<Long> livrosIds;

    public EmprestimosDTO(LocalDate dataEmprestimo, LocalDate dataEntrega, List<Long> livrosIds) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataEntrega = dataEntrega;
        this.livrosIds = livrosIds;
    }

    public EmprestimosDTO() {
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public List<Long> getLivrosIds() {
        return livrosIds;
    }

    public void setLivrosIds(List<Long> livrosIds) {
        this.livrosIds = livrosIds;
    }
}
