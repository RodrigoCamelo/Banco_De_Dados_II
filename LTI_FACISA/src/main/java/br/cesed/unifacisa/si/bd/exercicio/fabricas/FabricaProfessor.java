package br.cesed.unifacisa.si.bd.exercicio.fabricas;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Professor;

public class FabricaProfessor {

	public static Professor criar(String nome, int matricula) {
		return new Professor(nome, matricula);
	}
}