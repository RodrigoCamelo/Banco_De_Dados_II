package br.cesed.unifacisa.si.bd.exercicio.daos;

import java.util.ArrayList;
import java.util.List;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Professor;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOProfessor implements IDAO<Professor, Long> {

	private ArrayList<Professor> bancoDados = new ArrayList<Professor>();
	private Long idDaVez = 0L;
	
	public Professor criar(Professor objeto) {
		objeto.setId(idDaVez++);
		bancoDados.add(objeto);
		return objeto;
	}

	public Professor atualizar(Professor objeto) {
		for (int i = 0; i < bancoDados.size(); i++) {
			if(bancoDados.get(i).equals(objeto)) {
				return bancoDados.set(i, objeto);	
			}
		}
		return null;
	}

	public List<Professor> listaTudo() {
		return bancoDados;
	}

	public Professor pegarPorId(Long idobjeto) {
		for (Professor professor : bancoDados) {
			if(professor.getId().equals(idobjeto)) {
				return professor;
			}
		}
		return null;
	}

	public void remover(Professor objeto) {
		bancoDados.remove(objeto);
		
	}
}
