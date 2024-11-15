package br.spring.boot.Spring.model;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", allocationSize = 1, initialValue = 1)
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	@ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos = new HashSet<>();

    // Getters e Setters
}
