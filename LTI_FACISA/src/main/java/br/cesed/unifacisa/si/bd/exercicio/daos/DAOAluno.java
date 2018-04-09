package br.cesed.unifacisa.si.bd.exercicio.daos;

import java.util.ArrayList;
import java.util.List;

import br.cesed.unifacisa.si.bd.exercicio.entidades.Aluno;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOAluno implements IDAO<Aluno, Long> {

	private ArrayList<Aluno> bancoDados = new ArrayList<Aluno>();
	private Long idDaVez = 0L;
	
	public Aluno criar(Aluno objeto) {
		objeto.setId(idDaVez++);
		bancoDados.add(objeto);
		return objeto;
	}

	public Aluno atualizar(Aluno objeto) {
		for (int i = 0; i < bancoDados.size(); i++) {
			if(bancoDados.get(i).equals(objeto)) {
				return bancoDados.set(i, objeto);	
			}
		}
		return null;
	}

	public List<Aluno> listaTudo() {
		return bancoDados;
	}

	public Aluno pegarPorId(Long idobjeto) {
		for (Aluno aluno : bancoDados) {
			if(aluno.getId().equals(idobjeto)) {
				return aluno;
			}
		}
		return null;
	}

	public void remover(Aluno objeto) {
		bancoDados.remove(objeto);
	}
}