package br.cesed.unifacisa.si.bd.exercicio.testes.daos;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.unifacisa.si.bd.exercicio.daos.DAOAluno;
import br.cesed.unifacisa.si.bd.exercicio.daos.DAOProfessor;
import br.cesed.unifacisa.si.bd.exercicio.daos.DAOProjeto;
import br.cesed.unifacisa.si.bd.exercicio.daos.DAOTecnologia;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Aluno;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Professor;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Projeto;
import br.cesed.unifacisa.si.bd.exercicio.entidades.Tecnologia;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.AlunoInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.MatriculaInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.PeriodoInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.ProfessorEmProjetoInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.ProfessorInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.SemTecnologiaInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.excecoes.TecnologiaInvalidoException;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaAluno;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaProfessor;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaProjeto;
import br.cesed.unifacisa.si.bd.exercicio.fabricas.FabricaTecnologia;
import br.cesed.unifacisa.si.bd.exercicio.interfaces.IDAO;

public class DAOProjetoTeste {

	private static IDAO<Projeto, Long> daoPro;
	private static FabricaProjeto fabricaPro;
	private ArrayList<Aluno> alunoList = new ArrayList<Aluno>();
	private static IDAO<Aluno, Long> dao;
	private static FabricaAluno fabrica;
	private ArrayList<Tecnologia> tecnologiaList = new ArrayList<Tecnologia>();
	private static IDAO<Tecnologia, Long> daoTec;
	private static FabricaTecnologia fabricaTec;
	private static IDAO<Professor, Long> daoProf;
	private static FabricaProfessor fabricaProf;
	
	@Before
	public void conectandoBancoDandos() {
		daoPro = new DAOProjeto();
		dao = new DAOAluno();
		daoTec = new DAOTecnologia();
		daoProf = new DAOProfessor();
	}
	
	@Test
	public void testeCriaProjeto() 
		throws TecnologiaInvalidoException, AlunoInvalidoException, ProfessorInvalidoException, ProfessorEmProjetoInvalidoException, SemTecnologiaInvalidoException, PeriodoInvalidoException, MatriculaInvalidoException {
		
		Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
		aluno = dao.criar(aluno);
		alunoList.add(aluno);
		Aluno aluno2 = fabrica.criar("Outro", "535875", 8);
		aluno2 = dao.criar(aluno2);
		alunoList.add(aluno2);
		Tecnologia tecnologia = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		tecnologia = daoTec.criar(tecnologia);
		tecnologiaList.add(tecnologia);
		Tecnologia tecnologia2 = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		tecnologia2 = daoTec.criar(tecnologia2);
		tecnologiaList.add(tecnologia2);
		Professor professor = fabricaProf.criar("Adriano", 156);
		professor = daoProf.criar(professor);
		Projeto projeto = fabricaPro.criar(alunoList, tecnologiaList, professor, new Date(2018,03,12), new Date(2018,06,15), "Desenvolvimento", "App", "App de teste");
		daoPro.criar(projeto);
		Assert.assertTrue(projeto.getId() != null);
	}
	
	@Test
	public void testeRemoveProjeto() 
		throws TecnologiaInvalidoException, AlunoInvalidoException, ProfessorInvalidoException, ProfessorEmProjetoInvalidoException, SemTecnologiaInvalidoException, PeriodoInvalidoException, MatriculaInvalidoException {
		
		Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
		aluno = dao.criar(aluno);
		alunoList.add(aluno);
		Aluno aluno2 = fabrica.criar("Outro", "535875", 8);
		aluno2 = dao.criar(aluno2);
		alunoList.add(aluno2);
		Tecnologia tecnologia = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		tecnologia = daoTec.criar(tecnologia);
		tecnologiaList.add(tecnologia);
		Tecnologia tecnologia2 = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		tecnologia2 = daoTec.criar(tecnologia2);
		tecnologiaList.add(tecnologia2);
		Professor professor = fabricaProf.criar("Adriano", 156);
		professor = daoProf.criar(professor);
		Projeto projeto = fabricaPro.criar(alunoList, tecnologiaList, professor, new Date(2018,03,12), new Date(2018,06,15), "Desenvolvimento", "App", "App de teste");
		daoPro.criar(projeto);
		Assert.assertTrue(projeto.getId() != null);
		Assert.assertTrue(daoPro.listaTudo().size() == 1);
		daoPro.remover(projeto);
		Assert.assertTrue(daoPro.listaTudo().size() == 0);
	}
	
	@Test
	public void testeAtualizarProjeto() 
		throws TecnologiaInvalidoException, AlunoInvalidoException, ProfessorInvalidoException, ProfessorEmProjetoInvalidoException, SemTecnologiaInvalidoException, PeriodoInvalidoException, MatriculaInvalidoException {
		
		Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
		aluno = dao.criar(aluno);
		alunoList.add(aluno);
		Aluno aluno2 = fabrica.criar("Outro", "535875", 8);
		aluno2 = dao.criar(aluno2);
		alunoList.add(aluno2);
		Tecnologia tecnologia = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		tecnologia = daoTec.criar(tecnologia);
		tecnologiaList.add(tecnologia);
		Tecnologia tecnologia2 = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
		tecnologia2 = daoTec.criar(tecnologia2);
		tecnologiaList.add(tecnologia2);
		Professor professor = fabricaProf.criar("Adriano", 156);
		professor = daoProf.criar(professor);
		Projeto projeto = fabricaPro.criar(alunoList, tecnologiaList, professor, new Date(2018,03,12), new Date(2018,06,15), "Desenvolvimento", "App", "App de teste");
		daoPro.criar(projeto);
		projeto.setAreaRelacionada("Tecnologia");
		projeto = daoPro.atualizar(projeto);
		Assert.assertTrue(projeto.getId() != null);
		Assert.assertEquals("Tecnologia", projeto.getAreaRelacionada());
	}
	
	@Test
	public void testePegaPorIdProjeto()  {
		
		try {
			Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
			aluno = dao.criar(aluno);
			alunoList.add(aluno);
			Aluno aluno2 = fabrica.criar("Outro", "535875", 8);
			aluno2 = dao.criar(aluno2);
			alunoList.add(aluno2);
			Tecnologia tecnologia = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
			tecnologia = daoTec.criar(tecnologia);
			tecnologiaList.add(tecnologia);
			Tecnologia tecnologia2 = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
			tecnologia2 = daoTec.criar(tecnologia2);
			tecnologiaList.add(tecnologia2);
			Professor professor = fabricaProf.criar("Adriano", 156);
			professor = daoProf.criar(professor);
			Projeto projeto = fabricaPro.criar(alunoList, tecnologiaList, professor, new Date(2018,03,12), new Date(2018,06,15), "Desenvolvimento", "App", "App de teste");
			daoPro.criar(projeto);
			Assert.assertNotNull(projeto.getId());
			
			Assert.assertTrue(dao.pegarPorId(projeto.getId()).equals(dao.listaTudo().get(0)));
		} catch (Exception e) {
			fail("Algo");
		}
	}
	
	@Test
	public void testeListaProfessor() {
		
		try {
			for (int i = 0; i < 10; i++) {
				Aluno aluno = fabrica.criar("Fulhano", "123456", 9);
				aluno = dao.criar(aluno);
				alunoList.add(aluno);
				Aluno aluno2 = fabrica.criar("Outro", "535875", 8);
				aluno2 = dao.criar(aluno2);
				alunoList.add(aluno2);
				Tecnologia tecnologia = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
				tecnologia = daoTec.criar(tecnologia);
				tecnologiaList.add(tecnologia);
				Tecnologia tecnologia2 = fabricaTec.criar("Smarphone", "Algo usavel", "Para implementar apps", "Alguma coisa");
				tecnologia2 = daoTec.criar(tecnologia2);
				tecnologiaList.add(tecnologia2);
				Professor professor = fabricaProf.criar("Adriano", 156);
				professor = daoProf.criar(professor);
				Projeto projeto = fabricaPro.criar(alunoList, tecnologiaList, professor, new Date(2018,03,12), new Date(2018,06,15), "Desenvolvimento", "App", "App de teste");
				daoPro.criar(projeto);
				Assert.assertNotNull(projeto.getId());
			}
			Assert.assertTrue(daoPro.listaTudo().size() == 10);
		} catch (Exception e) {
			fail("Algo");
		}
	}
	
	@After
	public void desconectandoBancoDados() {
		
		daoPro = null;
		dao = null;
		daoTec = null;
		daoProf = null;
	}
}
