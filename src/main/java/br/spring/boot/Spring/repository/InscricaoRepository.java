package br.spring.boot.Spring.repository;

import br.spring.boot.Spring.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

}