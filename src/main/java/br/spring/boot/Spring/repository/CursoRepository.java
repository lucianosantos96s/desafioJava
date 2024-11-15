package br.spring.boot.Spring.repository;

import br.spring.boot.Spring.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {

}
