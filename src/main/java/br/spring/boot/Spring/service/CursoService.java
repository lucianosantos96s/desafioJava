package br.spring.boot.Spring.service;

import br.spring.boot.Spring.model.Aluno;
import br.spring.boot.Spring.model.Curso;
import br.spring.boot.Spring.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

	private final AlunoService alunoService;
    private final CursoRepository cursoRepository;
   

    @Autowired
    public CursoService(CursoRepository cursoRepository, AlunoService alunoService) {
        this.cursoRepository = cursoRepository;
        this.alunoService = alunoService;
    }

    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void inscreverAluno(Long alunoId, Long cursoId) {
        Aluno aluno = alunoService.buscarAlunoPorId(alunoId);
        Curso curso = buscarCursoPorId(cursoId);
        curso.getAlunos().add(aluno);
        cursoRepository.save(curso);
    }
}
