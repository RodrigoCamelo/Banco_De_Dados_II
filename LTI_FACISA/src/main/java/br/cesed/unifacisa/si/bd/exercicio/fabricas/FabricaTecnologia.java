package br.cesed.unifacisa.si.bd.exercicio.fabricas;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Tecnologia;

public class FabricaTecnologia {

	public static Tecnologia criar(String nome, String descricao, String arearelacionada, String documentacao) {
		return new Tecnologia(nome, descricao, arearelacionada, documentacao);
	}
}