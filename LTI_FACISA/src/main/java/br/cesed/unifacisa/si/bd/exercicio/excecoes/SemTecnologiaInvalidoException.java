package br.cesed.unifacisa.si.bd.exercicio.excecoes;

public class SemTecnologiaInvalidoException extends Exception {

	public SemTecnologiaInvalidoException() {
		super("Não tem nemhuma tecnologia no projeto.");
	}
}
