package br.cesed.unifacisa.si.bd.exercicio.daos;

import java.util.ArrayList;
import java.util.List;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Tecnologia;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOTecnologia implements IDAO<Tecnologia, Long> {

	
	private ArrayList<Tecnologia> bancoDados = new ArrayList<Tecnologia>();
	private Long idDaVez = 0L;
	
	public Tecnologia criar(Tecnologia objeto) {
		objeto.setId(idDaVez++);
		bancoDados.add(objeto);
		return objeto;
	}

	public Tecnologia atualizar(Tecnologia objeto) {
		for (int i = 0; i < bancoDados.size(); i++) {
			if(bancoDados.get(i).equals(objeto)) {
				return bancoDados.set(i, objeto);	
			}
		}
		return null;
	}

	public List<Tecnologia> listaTudo() {
		return bancoDados;
	}

	public Tecnologia pegarPorId(Long idobjeto) {
		for (Tecnologia tecnologia : bancoDados) {
			if(tecnologia.getId().equals(idobjeto)) {
				return tecnologia;
			}
		}
		return null;
	}

	public void remover(Tecnologia objeto) {
		bancoDados.remove(objeto);
	}

	
}
