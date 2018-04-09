package br.cesed.unifacisa.si.bd.exercicio.testes.daos;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.unifacisa.si.bd.exercicio.daos.DAOProfessor;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Professor;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaProfessor;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOProfesorTeste {

	private static IDAO<Professor, Long> dao;
	private static FabricaProfessor fabrica;
	
	@Before
	public void conectandoBancoDandos() {
		dao = new DAOProfessor();
	}
	
	@Test
	public void testeCriaProfessor() {
		
		Professor professor = fabrica.criar("Fulhano", 156);
		dao.criar(professor);
		Assert.assertTrue(professor.getId() != null);
	}
	
	@Test
	public void testeRemoveProfessor()  {
		
		Professor professor = fabrica.criar("Fulhano", 9);
		dao.criar(professor);
		Assert.assertTrue(professor.getId() != null);
		Assert.assertTrue(dao.listaTudo().size() == 1);
		dao.remover(professor);
		Assert.assertTrue(dao.listaTudo().size() == 0);
	}
	
	@Test
	public void testeAtualizarProfessor() {
		
		Professor professor = fabrica.criar("Fulhano", 9);
		dao.criar(professor);
		professor.setNome("Outra pessoa");
		professor = dao.atualizar(professor);
		Assert.assertTrue(professor.getId() != null);
		Assert.assertEquals("Outra pessoa", professor.getNome());
	}
	
	@Test
	public void testePegaPorIdProfessor()  {
		
		try {
			Professor professor = fabrica.criar("Fulhano", 9);
			dao.criar(professor);
			Assert.assertNotNull(professor.getId());
			
			Assert.assertTrue(dao.pegarPorId(professor.getId()).equals(dao.listaTudo().get(0)));
		} catch (Exception e) {
			fail("Algo");
		}
	}
	
	@Test
	public void testeListaProfessor() {
		
		try {
			for (int i = 0; i < 10; i++) {
				Professor professor = fabrica.criar("Fulhano", 9);
				dao.criar(professor);
				Assert.assertNotNull(professor.getId());
			}
			Assert.assertTrue(dao.listaTudo().size() == 10);
		} catch (Exception e) {
			fail("Algo");
		}
	}
	
	@After
	public void desconectandoBancoDados() {
		
		dao = null;
	}
}
