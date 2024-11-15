package br.spring.boot.Spring.populator;

import br.spring.boot.Spring.dto.AlunoDTO;
import br.spring.boot.Spring.dto.CursoDTO;
import br.spring.boot.Spring.model.Aluno;
import br.spring.boot.Spring.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InscricaoPopulator {
    InscricaoPopulator INSTANCE = Mappers.getMapper(InscricaoPopulator.class);

    AlunoDTO toAlunoDTO(Aluno aluno);
    CursoDTO toCursoDTO(Curso curso);
}
