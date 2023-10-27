package com.estudos.sistemabiblioteca.repo;

import com.estudos.sistemabiblioteca.model.Emprestimos;
import org.hibernate.boot.JaccPermissionDefinition;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos,Long> {
}
