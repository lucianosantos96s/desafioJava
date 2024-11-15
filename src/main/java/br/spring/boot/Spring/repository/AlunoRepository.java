package br.spring.boot.Spring.repository;

import br.spring.boot.Spring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {

}
