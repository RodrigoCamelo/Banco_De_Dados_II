package br.cesed.unifacisa.si.bd.exercicio.fabricas;

import java.util.ArrayList;
import java.util.Date;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Aluno;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Professor;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Projeto;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Tecnologia;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.AlunoInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.ProfessorEmProjetoInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.ProfessorInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.SemTecnologiaInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.TecnologiaInvalidoException;

public class FabricaProjeto {

	public static Projeto criar(ArrayList<Aluno> alunos, ArrayList<Tecnologia> tecnologias, Professor responsavel,
			Date inicio, Date conclusao, String areaRelacionada, String titulo, String descricao) 
			throws TecnologiaInvalidoException, AlunoInvalidoException, ProfessorInvalidoException, ProfessorEmProjetoInvalidoException, SemTecnologiaInvalidoException {
		
		for(Tecnologia tec : tecnologias) {
			if(tec.getId() == null) {
				throw new TecnologiaInvalidoException();
			}
		}
		
		for(Aluno aluno : alunos) {
			if(aluno.getId() == null) {
				throw new AlunoInvalidoException();
			}
		}
		
		if(responsavel.getId() == null) {
			throw new ProfessorInvalidoException();
		}
		
		if(responsavel.isEmProjeto()) {
			throw new ProfessorEmProjetoInvalidoException();
		}
		
		if(tecnologias.size() <= 1) {
			throw new SemTecnologiaInvalidoException();
		}
		
		responsavel.setEmProjeto(true);
		
		return new Projeto(alunos, tecnologias, responsavel, inicio, conclusao, areaRelacionada, titulo, descricao);
	}
}
