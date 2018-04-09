package br.cesed.unifacisa.si.bd.exercicio.testes.daos;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.unifacisa.si.bd.exercicio.daos.DAOAluno;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Aluno;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.MatriculaInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.PeriodoInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaAluno;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;


public class DAOAlunoTeste {

	private static IDAO<Aluno, Long> dao;
	private static FabricaAluno fabrica;
	
	@Before
	public void conectandoBancoDandos() {
		dao = new DAOAluno();
	}
	
	@Test
	public void testeCriaAluno() throws PeriodoInvalidoException, MatriculaInvalidoException {
		
		Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
		dao.criar(aluno);
		Assert.assertTrue(aluno.getId() != null);
	}
	
	@Test
	public void testeRemoveAluno() throws PeriodoInvalidoException, MatriculaInvalidoException {
		
		Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
		dao.criar(aluno);
		Assert.assertTrue(aluno.getId() != null);
		Assert.assertTrue(dao.listaTudo().size() == 1);
		dao.remover(aluno);
		Assert.assertTrue(dao.listaTudo().size() == 0);
	}
	
	@Test
	public void testeAtualizarAluno() throws PeriodoInvalidoException, MatriculaInvalidoException {
		
		Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
		aluno = dao.criar(aluno);
		aluno.setNome("Outra pessoa");
		aluno = dao.atualizar(aluno);
		Assert.assertTrue(aluno.getId() != null);
		Assert.assertEquals("Outra pessoa", aluno.getNome());
	}
	
	@Test
	public void testePegaPorIdAluno() throws PeriodoInvalidoException, MatriculaInvalidoException {
		
		try {
			Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
			aluno = dao.criar(aluno);
			Assert.assertNotNull(aluno.getId());
			
			Assert.assertTrue(dao.pegarPorId(aluno.getId()).equals(dao.listaTudo().get(0)));
		} catch (Exception e) {
			fail("Algo");
		}
	}
	
	@Test
	public void testeListaAluno() throws PeriodoInvalidoException, MatriculaInvalidoException {
		
		try {
			for (int i = 0; i < 10; i++) {
				Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
				dao.criar(aluno);
				Assert.assertNotNull(aluno.getId());
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
