package br.cesed.unifacisa.si.bd.exercicio.fabricas;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Aluno;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.MatriculaInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.PeriodoInvalidoException;

public class FabricaAluno {

	public static Aluno criar(String nome, String matricula, Integer periodo) throws PeriodoInvalidoException, MatriculaInvalidoException {

		if(periodo == null || periodo < 4) {
			throw new PeriodoInvalidoException();	
		}
		
		if(matricula == null || matricula.trim().length() == 0 || matricula.trim().length() < 5) {
			throw new MatriculaInvalidoException();
		}
		
		return new Aluno(nome, matricula, periodo);
	}
}
