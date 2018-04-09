package br.cesed.unifacisa.si.bd.exercicio.testes.daos;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.unifacisa.si.bd.exercicio.daos.DAOTecnologia;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Tecnologia;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaTecnologia;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOTecnologiaTeste {

	private static IDAO<Tecnologia, Long> dao;
	private static FabricaTecnologia fabrica;
	
	@Before
	public void conectandoBancoDandos() {
		dao = new DAOTecnologia();
	}
	
	@Test
	public void testeCriaTecnologia() {
		
		Tecnologia tecnologia = fabrica.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		dao.criar(tecnologia);
		Assert.assertTrue(tecnologia.getId() != null);
	}
	
	@Test
	public void testeRemoveTecnologia() {
		
		Tecnologia tecnologia = fabrica.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		dao.criar(tecnologia);
		Assert.assertTrue(tecnologia.getId() != null);
		Assert.assertTrue(dao.listaTudo().size() == 1);
		dao.remover(tecnologia);
		Assert.assertTrue(dao.listaTudo().size() == 0);
	}
	
	@Test
	public void testeAtualizarTecnologia() {
		
		Tecnologia tecnologia = fabrica.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		dao.criar(tecnologia);
		tecnologia.setNome("Outra pessoa");
		tecnologia = dao.atualizar(tecnologia);
		Assert.assertTrue(tecnologia.getId() != null);
		Assert.assertEquals("Outra pessoa", tecnologia.getNome());
	}
	
	@Test
	public void testePegaPorIdTecnologia()  {
		
		try {
			Tecnologia tecnologia = fabrica.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
			dao.criar(tecnologia);
			Assert.assertNotNull(tecnologia.getId());
			
			Assert.assertTrue(dao.pegarPorId(tecnologia.getId()).equals(dao.listaTudo().get(0)));
		} catch (Exception e) {
			fail("Algo");
		}
	}
	
	@Test
	public void testeListaTecnologia() {
		
		try {
			for (int i = 0; i < 10; i++) {
				Tecnologia tecnologia = fabrica.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
				dao.criar(tecnologia);
				Assert.assertNotNull(tecnologia.getId());
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
