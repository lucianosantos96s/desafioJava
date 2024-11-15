package br.spring.boot.Spring.controllers;

import br.spring.boot.Spring.model.Aluno;
import br.spring.boot.Spring.model.Curso;
import br.spring.boot.Spring.service.AlunoService;
import br.spring.boot.Spring.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/br-spring")
public class GreetingsController {

    private final AlunoService alunoService;
    private final CursoService cursoService;

    @Autowired
    public GreetingsController(AlunoService alunoService, CursoService cursoService) {
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }
    
    @PostMapping("/alunos")
    @ResponseBody
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno alunoCriado = alunoService.cadastrarAluno(aluno);
        return new ResponseEntity<>(alunoCriado, HttpStatus.CREATED);
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso) {
        Curso cursoSalvo = cursoService.cadastrarCurso(curso);
        return ResponseEntity.ok(cursoSalvo);
    }

    @PostMapping("/inscricoes")
    public ResponseEntity<Void> inscreverAluno(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        cursoService.inscreverAluno(alunoId, cursoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/alunos/{id}/cursos")
    public ResponseEntity<List<Curso>> listarCursosPorAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok(List.copyOf(aluno.getCursos()));
    }

    @GetMapping("/cursos/{id}/alunos")
    public ResponseEntity<List<Aluno>> listarAlunosPorCurso(@PathVariable Long id) {
        Curso curso = cursoService.buscarCursoPorId(id);
        return ResponseEntity.ok(List.copyOf(curso.getAlunos()));
    }
}
