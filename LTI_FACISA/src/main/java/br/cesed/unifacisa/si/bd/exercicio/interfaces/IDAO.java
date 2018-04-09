package br.cesed.unifacisa.si.bd.exercicio.interfaces;

import java.util.List;

public interface IDAO<T, ID> {
	
	public T criar(T objeto);
	public T atualizar(T objeto);
	public void remover(T objeto);
	public List<T> listaTudo();
	public T pegarPorId(ID idobjeto);
}