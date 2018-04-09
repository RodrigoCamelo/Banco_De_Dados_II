package br.cesed.unifacisa.si.bd.exercicio.excecoes;

public class ProfessorEmProjetoInvalidoException extends Exception {

	public ProfessorEmProjetoInvalidoException() {
		super("O professor ja esta em um projeto.");
	}
}
