package br.cesed.unifacisa.si.bd.exercicio.daos;

import java.util.ArrayList;
import java.util.List;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Projeto;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOProjeto implements IDAO<Projeto, Long> {

	private ArrayList<Projeto> bancoDados = new ArrayList<Projeto>();
	private Long idDaVez = 0L;
	
	public Projeto criar(Projeto objeto) {
		objeto.setId(idDaVez++);
		bancoDados.add(objeto);
		return null;
	}

	public Projeto atualizar(Projeto objeto) {
		for (int i = 0; i < bancoDados.size(); i++) {
			if(bancoDados.get(i).equals(objeto)) {
				return bancoDados.set(i, objeto);	
			}
		}
		return null;
	}

	public List<Projeto> listaTudo() {
		return bancoDados;
	}

	public Projeto pegarPorId(Long idobjeto) {
		for (Projeto projeto : bancoDados) {
			if(projeto.getId().equals(idobjeto)) {
				return projeto;
			}
		}
		return null;
	}

	public void remover(Projeto objeto) {
		bancoDados.remove(objeto);
	}
}
